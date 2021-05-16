enum AnimalType { DOG, CAT }

class Animal {
    AnimalType type;
    long arrival;

    public Animal(AnimalType type, long arrival) {
        this.type = type;
        this.arrival = arrival;
    }
}

class AdoptionQueue {
    // CAUTION!!! QUEUE operations
    // add(item) and offer(item)
    // remove() and poll()
    // add() and remove() throw exception
    Queue<Animal> dogs = new LinkedList();
    Queue<Animal> cats = new LinkedList();

    public void enqueue(Animal animal) {
        if (animal == null) return;

        switch (animal.type) {
            case DOG:
                dogs.offer(animal);
                break;
            case CAT:
                cats.offer(animal);
        }
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return cats.poll(); 
        if (cats.isEmpty()) return dogs.poll(); 

        return (dogs.peek().arrival < cats.peek().arrival) ? dogs.poll() : cats.poll();
    }

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }
}

// test
AdoptionQueue aq = new AdoptionQueue()
aq.enqueue(new Animal(AnimalType.DOG, 1));
aq.enqueue(new Animal(AnimalType.DOG, 2));
aq.enqueue(new Animal(AnimalType.DOG, 4));
aq.enqueue(new Animal(AnimalType.DOG, 5));
aq.enqueue(new Animal(AnimalType.CAT, 2));
aq.enqueue(new Animal(AnimalType.CAT, 3));
aq.enqueue(new Animal(AnimalType.CAT, 5));
aq.enqueue(new Animal(AnimalType.CAT, 10));

while (!aq.isEmpty()) {
    Animal a = aq.dequeueAny();

    System.out.println(a.type + " " + a.arrival);
}

