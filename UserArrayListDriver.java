class UserArrayListDriver {
	public static void main(String[] args) {
		
		UserArrayList<String> list = new UserArrayList<>();
		
        System.out.println("Is list empty? " + list.isEmpty());

        // Adding elements
        System.out.println("\n Adding elements");
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");

        System.out.println("\nAfter adding elements:");
        System.out.println(list);

        // Add at specific index
        System.out.println("\nAdd at specific index");
        list.add(2, "SQL");
        System.out.println("After adding SQL at index 2:");
        System.out.println(list);

        // Get element
        System.out.println("\n Get element");
        System.out.println("Element at index 1: " + list.get(1));

        // Set element
        System.out.println("\n Set element");
        list.set(3, "Spring");
        System.out.println("After replacing index 3 with Spring:");
        System.out.println(list);

        // indexOfpl
        System.out.println("\n indexOf");
        System.out.println("Index of Java: " + list.indexOf("Java"));

        // contains
        System.out.println("\n contains");
        System.out.println("Contains Python? " + list.contains("Python"));

        // Remove by index
        System.out.println("\nRemove by index");
        list.remove(1);
        System.out.println("After removing element at index 1:");
        System.out.println(list);

        // Remove by object
        System.out.println("\nRemove by object");
        list.remove("Java");
        System.out.println("After removing Java:");
        System.out.println(list);

        // Size
        System.out.println("\n Size");
        System.out.println("Current size: " + list.size());

        // Iterate using for-each
        System.out.println("Iterating using for-each:");
        for (String lang : list) {
            System.out.println(lang);
        }

        // Clear
        System.out.println("\n Clear");
        list.clear();
        System.out.println("After clear:");
        System.out.println(list);
        System.out.println("Is list empty now? " + list.isEmpty());
	}
}