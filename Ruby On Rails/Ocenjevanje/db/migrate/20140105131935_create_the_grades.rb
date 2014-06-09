class CreateTheGrades < ActiveRecord::Migration
  def change
    create_table :the_grades do |t|
      t.string :user
      t.string :proj
      t.string :ocena_p
      t.string :komentar_p
      t.string :ocena_s
      t.string :komentar_s
      t.string :mateName
      t.string :ocena_m
      t.string :komentar_m
      t.string :status

      t.timestamps
    end
  end
end
