package stacks_queues;

import java.util.LinkedList;

/*
 * Cracking the Code 3.7, implement Animal Shelter using LinkedList as Queue
 */
public class AnimalShelter {
	
	private int capacity = 0;
	private LinkedList<Animal> cats, dogs;
	private int order  = 0;
	
	public AnimalShelter(int capacity) {
		if(capacity > 0)
			this.capacity = capacity;
		
		cats = new LinkedList<>();
		dogs = new LinkedList<>();
	}
	
	public boolean isFull() {
		return dogs.size() + cats.size() == this.capacity;
	}
	
	public boolean hasAnimals() {
		return dogs.size() + cats.size() > 0;
	}
	
	public boolean hasCats() {
		return cats.size() > 0;
	}
	
	public boolean hasDogs() {
		return dogs.size() > 0;
	}
	
	public boolean enqueue(Animal animal) {
		if (this.isFull())
			return false;
		
		if(animal.type != Animal.ANIMAL_TYPE.DOG && animal.type != Animal.ANIMAL_TYPE.CAT)
			return false;
		
		switch(animal.type) {
			case DOG:
				dogs.addLast(animal);
				break;
			case CAT:
				cats.addLast(animal);
				break;
			default:
				return false;
		}
		
		animal.setOrder(order++);
		
		return true;
	}
	
	public Animal dequeueAny() {
		if (!hasAnimals()) {
			return null;
		}
		else if (hasDogs() && !hasCats()) {
			return dogs.removeFirst();
		}
		else if(hasCats() && !hasDogs()) {
			return cats.removeFirst();
		}
		else {
			Animal dog = dogs.getFirst();
			Animal cat = cats.getFirst();
			if(dog.compareTo(cat) < 0) {
				return dogs.removeFirst();
			}
			else {
				return cats.removeFirst();
			}
		}
	}
	
	public Animal dequeueCat() {
		if(!hasCats())
			return null;
		
		return cats.removeFirst();
	}
	
	public Animal dequeueDog() {
		if(!hasDogs())
			return null;
		
		return dogs.removeFirst();
	}
	
	public static class Animal implements Comparable{
		static enum ANIMAL_TYPE{
			DOG, CAT
		}
		
		private ANIMAL_TYPE type;
		private final String name;
		private int order;
		
		public Animal(String name, ANIMAL_TYPE type){
			this.name = name;
			this.type = type;
			this.order = 0;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setOrder(int order) {
			this.order = order;
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof Animal) {
				return this.order - ((Animal) o).order;
			}
			throw new IllegalArgumentException("Animal can only be compared with other Animal class");
		}
	}
	
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter(5);
		shelter.enqueue(new Animal("Bozo", Animal.ANIMAL_TYPE.DOG));
		shelter.enqueue(new Animal("Jao", Animal.ANIMAL_TYPE.CAT));
		shelter.enqueue(new Animal("Gato Vida Loca", Animal.ANIMAL_TYPE.CAT));
		shelter.enqueue(new Animal("Marley", Animal.ANIMAL_TYPE.DOG));
		shelter.enqueue(new Animal("Garfield", Animal.ANIMAL_TYPE.CAT));
		
		System.out.println(shelter.dequeueCat().getName());
		System.out.println(shelter.dequeueDog().getName());
		System.out.println(shelter.dequeueDog().getName());
		System.out.println(shelter.dequeueAny().getName());
		System.out.println(shelter.dequeueAny().getName());
		
	}
}
