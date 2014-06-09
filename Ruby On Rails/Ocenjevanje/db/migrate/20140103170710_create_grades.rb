class CreateGrades < ActiveRecord::Migration
  def change
    create_table :grades do |t|
      t.string :instructions
      t.string :prof
      t.string :asist
      t.string :stud
      t.string :status

      t.timestamps
    end
  end
end
