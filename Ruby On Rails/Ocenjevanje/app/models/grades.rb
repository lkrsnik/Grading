class Grades < ActiveRecord::Base
  attr_accessible :instructions, :asist, :prof, :stud, :status
end
