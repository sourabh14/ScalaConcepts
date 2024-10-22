class Dog(name: String) extends Animal, Runner:
    override def getName(): String = name

    override def getHabitat(): String = "Habitat"

    override def startRunning(): Unit = println("Started running")

    override def stopRunning(): Unit = println("Stopped running")

    def bark(): Unit = println("I am a barking dog")


