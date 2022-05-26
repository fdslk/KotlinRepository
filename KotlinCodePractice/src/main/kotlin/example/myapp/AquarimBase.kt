package example.myapp

import java.lang.Math.PI

open class AquarimBase(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
                get() = width * height * length / 1000
                set(value) {
                    height = (value * 1000) / (width * length)
                }
    open var shape = "rectangle"
    open var water: Double = 0.0
                get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): AquarimBase(height = height, width = diameter, length = diameter) {
    var towerTankShape: String = "tower"
    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8

    override var shape: String
        get() = towerTankShape
        set(value) {
            towerTankShape = value
        }
}

fun buildAquariumSub() {
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
    val towerTank = TowerTank(diameter = 25, height = 40)
    towerTank.printSize()
    towerTank.shape = "cylinder"
    towerTank.printSize()
}