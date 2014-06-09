# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20140105131935) do

  create_table "grades", :force => true do |t|
    t.string   "instructions"
    t.string   "prof"
    t.string   "asist"
    t.string   "stud"
    t.string   "status"
    t.datetime "created_at",   :null => false
    t.datetime "updated_at",   :null => false
  end

  create_table "projects", :force => true do |t|
    t.string   "naslov"
    t.string   "platforma"
    t.string   "mate1"
    t.string   "mate2"
    t.string   "sourceProject"
    t.string   "sourceCode"
    t.datetime "created_at",    :null => false
    t.datetime "updated_at",    :null => false
    t.string   "mate0"
  end

  create_table "the_grades", :force => true do |t|
    t.string   "user"
    t.string   "proj"
    t.string   "ocena_p"
    t.string   "komentar_p"
    t.string   "ocena_s"
    t.string   "komentar_s"
    t.string   "mateName"
    t.string   "ocena_m"
    t.string   "komentar_m"
    t.string   "status"
    t.datetime "created_at", :null => false
    t.datetime "updated_at", :null => false
  end

  create_table "users", :force => true do |t|
    t.string   "uporabnik"
    t.string   "pass1"
    t.string   "pass2"
    t.string   "ime"
    t.string   "priimek"
    t.string   "number"
    t.string   "email"
    t.string   "phone"
    t.string   "rank"
    t.datetime "created_at", :null => false
    t.datetime "updated_at", :null => false
  end

end
