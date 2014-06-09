class CreateProjects < ActiveRecord::Migration
  def change
    create_table :projects do |t|
      t.string :naslov
      t.string :platforma
      t.string :mate0
      t.string :mate1
      t.string :mate2
      t.string :sourceProject
      t.string :sourceCode

      t.timestamps
    end
  end
end
