class Users < ActiveRecord::Base
  attr_accessible :email, :ime, :number, :pass1, :pass2, :phone, :priimek, :rank, :uporabnik
end
