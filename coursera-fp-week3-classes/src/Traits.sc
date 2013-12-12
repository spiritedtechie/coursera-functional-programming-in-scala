object Traits {

	println(new Square(3, 3).surface)         //> 9

}

class Square(h:Int, w:Int) extends Shape with Planar {
	def height: Int = h
	def width: Int = w
}

class Shape

trait Planar {

	def height: Int
	def width: Int
	def surface = height * width
}