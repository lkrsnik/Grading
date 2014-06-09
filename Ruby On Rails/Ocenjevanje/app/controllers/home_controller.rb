class HomeController < ApplicationController
  def index



  end
  def registracija
    if request.post?
      @users=Users.new
      @users.uporabnik=params[:uporabnik]
      @users.pass1=params[:pass1]
      @users.pass2=params[:pass2]
      @users.ime=params[:ime]
      @users.priimek=params[:priimek]
      @users.number=params[:number]
      @users.email=params[:email]
      @users.phone=params[:phone]
      @users.rank=params[:rank]

      @users.save
    end
  end
  def projekti
    @findM0=Projects.where(mate0: session[:ime])
    @findM1=Projects.where(mate1: session[:ime])
    @findM2=Projects.where(mate2: session[:ime])
    if !@findM0.empty? or !@findM1.empty? or !@findM2.empty?
      puts "ZE IMA PROJEKT!"
    end
    if request.post?
      @projects=Projects.new
      @projects.naslov=params[:naslov]
      @projects.platforma=params[:platforma]
      @projects.mate1=params[:mate1]
      @projects.mate2=params[:mate2]
      @projects.sourceProject=params[:sourceProject]
      @projects.sourceCode=params[:sourceCode]

      @projects.mate0=session[:ime]

      @projects.save
    end
  end
  def prijava
    if request.post? and params.has_key?(:username)
      @user = params[:username]
      @pass = params[:password]
      @res = Users
            .where(uporabnik: @user)
            .where(pass1: @pass)
      if !@res.empty?
        session[:rank]=@res.pluck(:rank)
        session[:ime]=@res.pluck(:ime)[0]+" "+@res.pluck(:priimek)[0]
        redirect_to :action => 'index'
      end
    elsif request.post? and !params.has_key?(:username)
      session.delete("rank")
      session.delete("ime")
      session.delete(:proj)
    end
  end
  def ocenjevanje



    #Racunanje ocene
    @grading=Grades.where(id: 1)
    @finalGrade='Niste se ocenjeni'
    @projectsAll=Projects.all
    @myProj=nil

    Projects.all.each do |element|
      if element[:mate0]==session[:ime] || element[:mate1]==session[:ime] || element[:mate2]==session[:ime]
        @myProj=element[:naslov]
      end
    end

    TheGrade.all.each do |element|
      if element[:proj]==@myProj
        if !element[:komentar_p].nil?
          puts element[:komentar_p]
        end
        if !element[:komentar_s].nil?
          puts element[:komentar_s]
        end
        if !element[:komentar_m].nil?
          puts element[:komentar_m]
        end
      end
    end

    puts @myProj

    ocena_sv=0
    ocena_sc=0
    ocena_mv=0
    ocena_mc=0
    ocena_a=0
    ocena_p=0
    if @grading.pluck(:status)[0]=="1" && session[:rank][0]=="student" && (!Projects.where(mate0: session[:ime]).empty? || !Projects.where(mate1: session[:ime]).empty? || !Projects.where(mate2: session[:ime]).empty?)
      TheGrade.all.each do |element|
        if !element[:ocena_s].nil? && element[:proj]==@myProj
          ocena_sc=ocena_sc+1
          ocena_sv=ocena_sv+element[:ocena_s].to_d
        end
        if !element[:ocena_m].nil? && element[:proj]==@myProj
          ocena_mc=ocena_mc+1
          ocena_mv=ocena_mv+element[:ocena_m].to_d
        end
        if !element[:ocena_p].nil? && element[:proj]==@myProj
          if element[:user]==Users.where(rank: "profesor").pluck(:ime)[0]+" "+Users.where(rank: "profesor").pluck(:priimek)[0]
            ocena_p=element[:ocena_p].to_d
          else
            ocena_a=element[:ocena_p].to_d
          end

        end
      end
      if ocena_sc!=0 && ocena_mc!=0
        @finalGrade=((@grading.pluck(:prof)[0].to_d/100*ocena_p+@grading.pluck(:asist)[0].to_d/100*ocena_a+@grading.pluck(:stud)[0].to_d/100*((ocena_sv/ocena_sc+ocena_mv/ocena_mc)/2))*0.1).round
      end
    end

    #Akcije ocenjevanja
    @projName=Projects.where(naslov: session[:proj])
    #puts @projName.pluck(:mate0)[0]==session[:ime] || @projName.pluck(:mate1)[0]==session[:ime] || @projName.pluck(:mate2)[0]==session[:ime]
    @exists=TheGrade.where(user: session[:ime]).where(proj: session[:proj])
    puts @exists.empty?
    #puts session.has_key?(:proj)

    #Prvi form
    if request.post? && !(params.has_key?(:proOcena) or params.has_key?(:ocena) or params.has_key?(:ocenaZ))
      if params.has_key?(:groceries)
        puts params[:groceries]
        session.delete(:proj)
        session[:proj]=params[:groceries]
        #puts "KLELE"
        redirect_to :action => 'ocenjevanje'
      else
        session.delete(:proj)
      end

    #Drugi form
    elsif request.post?
      if session[:rank][0]=="profesor" or session[:rank][0]=="asistent"
        @thegrade=TheGrade.new
        @thegrade.user=session[:ime]
        @thegrade.proj=session[:proj]
        @thegrade.ocena_p=params[:proOcena]
        @thegrade.komentar_p=params[:comments]

        @thegrade.save


      #ocenjevanje drugega projekta
      elsif session[:rank][0]=="student" and !(@projName.pluck(:mate0)[0]==session[:ime] || @projName.pluck(:mate1)[0]==session[:ime] || @projName.pluck(:mate2)[0]==session[:ime])
        @thegrade=TheGrade.new
        @thegrade.user=session[:ime]
        @thegrade.proj=session[:proj]
        @thegrade.ocena_s=params[:ocena]
        @thegrade.komentar_s=params[:comments]

        @thegrade.save

        #@thegrade.uporabnik=params[:uporabnik]
      #ocenjevanje znotraj projekta
      elsif session[:rank][0]=="student"
        @thegrade=TheGrade.new
        @thegrade.user=session[:ime]
        @thegrade.proj=session[:proj]
        @thegrade.mateName=params[:mateName]
        @thegrade.ocena_m=params[:ocenaZ]
        @thegrade.komentar_m=params[:comments]

        @thegrade.save
      end
      session.delete(:proj)
    end

  end
  def kriterij

    @grading=Grades.where(id: 1)


    if request.post? && params.has_key?(:prof)
      puts session.has_key?(:rank)
      @grading.update(1,
                        instructions: params[:instructions],
                        prof: params[:prof],
                        asist: params[:asist],
                        stud: params[:stud])
    elsif request.post?
      if @grading.pluck(:status)[0]=="0"
      @grading.update(1,
                      status: "1")
      else
        @grading.update(1,
                        status: "0")
      end
    else
      #@pluck=@grading.pluck(:prof,:asist,:stud, :instructions)

      @prof=@grading.pluck(:prof)
      @asist=@grading.pluck(:asist)
      @stud=@grading.pluck(:stud)
    end
    #@grading.update(1,
     #               instructions: params[:instructions],
      #              prof: params[:prof],
       #             asist: params[:asist],
        #            stud: params[:stud])
  end
end
