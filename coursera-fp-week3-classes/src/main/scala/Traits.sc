println(new Square(3, 3).surface)               //> 9

class Square(val height: Int, val width: Int) extends Shape with Planar

class Shape

trait Planar {

  def height: Int
  def width: Int
  def surface = height * width
}