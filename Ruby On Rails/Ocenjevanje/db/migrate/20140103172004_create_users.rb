class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :uporabnik
      t.string :pass1
      t.string :pass2
      t.string :ime
      t.string :priimek
      t.string :number
      t.string :email
      t.string :phone
      t.string :rank

      t.timestamps
    end
  end
end
