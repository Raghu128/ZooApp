package org.example;

import java.util.*;

interface ZooEntity {
    int getId();
}

interface Describable {
    String getDescription();
}

abstract class BaseEntity implements ZooEntity, Describable {
    private int id;
    private String description;

    public BaseEntity(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class Attraction extends BaseEntity {
    private static int currId = 1;
    private String name;
    private int visitorCount;
    private long ticketPrice;

    public Attraction(String name, String description, long ticketPrice) {
        super(currId, description);
        currId++;
        this.ticketPrice = ticketPrice;
        this.name = name;
        this.visitorCount = 0;
    }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            double discountFactor = (100 - discountPercentage) / 100.0;
            return this.ticketPrice * discountFactor;
        } else {
            System.out.println("Invalid discount percentage. Please provide a value between 0 and 100.");
            return ticketPrice;
        }
    }
    public int getVisitorCount() {
        return visitorCount;
    }
    public void incrementVisitorCount() {
        visitorCount++;
    }

    public void decrementVisitorCount() {
        visitorCount--;
    }


    public void setId(int id) {
        super.setId(id);
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setDescription(String description) {
        super.setDescription(description);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}

class Animal extends BaseEntity {
    private static int currIdOfAnimal = 1;
    private String name;
    private String type;

    public Animal(String name, String type) {
        super(currIdOfAnimal,"NOTHING" );
        currIdOfAnimal++;

        this.name = name;
        this.type = type;
    }

    public String readAbout() {
        return "Animal Name: " + getName() + "\n" + "Animal Type: " + getType();
    }

    public String feed() {
        return "You have fed the " + getName() + ". It made a sound: " + makeSound();
    }

    public String makeSound() {
        switch (this.getType()) {
            case "Mammal":
                return "Roar";
            case "Amphibian":
                return "Croak";
            case "Reptile":
                return "Hiss";
            default:
                return "Unknown sound";
        }
    }

    public int getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal ID: " + super.getId() + "\nName: " + name + "\nType: " + type;
    }
}

class Feedback {
    private String text;

    public Feedback(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Event {
    private Attraction attraction;
    private String openingTime;
    private String closingTime;
    private double ticketPrice;

    public Event(Attraction attraction, String openingTime, String closingTime, double ticketPrice) {
        this.attraction = attraction;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
    }


    public Attraction getAttraction() {
        return attraction;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Event at " + attraction.getName() +
                "\nOpening Time: " + openingTime +
                "\nClosing Time: " + closingTime +
                "\nTicket Price: $" + ticketPrice;
    }
}

class Discount {
    private String category;
    private double percentage;
    private String code;
    public Discount(String category, double percentage, String code) {
        this.category = category;
        this.code = code;
        this.percentage = percentage;
    }

    public String getCategory() {
        return category;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getDescription() {
        return category;
    }

    public String getDiscountCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(boolean description) {
        this.code = code;
    }

}

class SpecialDeal {
    private int requiredAttractionCount;
    private double discountPercentage;

    public SpecialDeal(int requiredAttractionCount, double discountPercentage) {
        this.requiredAttractionCount = requiredAttractionCount;
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setRequiredAttractionCount(int requiredAttractionCount) {
        this.requiredAttractionCount = requiredAttractionCount;
    }
    public double applyDiscount(double ticketPrice) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            double discountFactor = (100 - discountPercentage) / 100.0;
            return ticketPrice * discountFactor;
        } else {
            System.out.println("Invalid discount percentage. Please provide a value between 0 and 100.");
            return ticketPrice;
        }
    }
    public int getRequiredAttractionCount() {
        return requiredAttractionCount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
class Ticket {
    private Attraction attraction;
    private double price;
    private boolean used;

    public Ticket(Attraction attraction, double price) {
        this.attraction = attraction;
        this.price = price;
        this.used = false;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public double getPrice() {
        return price;
    }

    public boolean isUsed() {
        return used;
    }

    public void markAsUsed() {
        used = true;
    }

    @Override
    public String toString() {
        return "Ticket for " + attraction.getName() + " - ₹" + price + (used ? " (Used)" : " (Valid)");
    }
}

class Visitor implements ZooEntity {
    private static int currId = 1;
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private boolean isPremium;
    private List<String> visitedAttractions = new ArrayList<>();
    private String membershipType;
    private List<Ticket> purchasedTickets = new ArrayList<>();

    public Visitor(String name, int age, String phoneNumber, String email, String password, double balanceMoney) {
        this.id = currId++;
        this.balance = balanceMoney;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getTicketCount() {
        return purchasedTickets.size();
    }
    public boolean hasTicketForAttraction(Attraction attraction) {
        List<Ticket> purchasedTickets = getPurchasedTickets();

        for (Ticket ticket : purchasedTickets) {
            if (ticket.getAttraction() == attraction) {
                return true;
            }
        }

        return false;
    }

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(List<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public void buyTicket(Attraction attraction, double ticketPrice) {
        if (balance >= ticketPrice) {
            balance -= ticketPrice;

            purchasedTickets.add(new Ticket(attraction, ticketPrice));

            System.out.println("The ticket for " + attraction.getName() + " was purchased successfully.");
        } else {
            System.out.println("Insufficient balance to purchase the ticket.");
        }
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void buyMembership(String membershipType, double cost) {
        if (balance >= cost) {

            balance -= cost;

            this.membershipType = membershipType;

            System.out.println(membershipType + " Membership purchased successfully.");
        } else {
            System.out.println("Insufficient balance to purchase " + membershipType + " Membership.");
        }
    }

    @Override
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void visitorMenu(Scanner scanner) {

    }
}

class Zoo {
    private static List<Attraction> attractions = new ArrayList<>();
    private static List<Animal> animals = new ArrayList<>();
    private static List<Visitor> visitors = new ArrayList<>();
    private static List<Feedback> feedbacks = new ArrayList<>();
    private static List<Discount> discounts = new ArrayList<>();
    private static List<SpecialDeal> specialDeals = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();


    public List<SpecialDeal> getSpecialDeals() {
        return specialDeals;
    }
    public void addFeedback(Visitor visitor, String feedbackText) {
        Feedback feedback = new Feedback(visitor.getName() + ": " + feedbackText);
        feedbacks.add(feedback);
    }
    public List<Discount> getDiscounts() {
        return discounts;
    }
    public void ticketPrice() {
        for (Attraction attraction : attractions) {
            double ticketPrice = attraction.getTicketPrice();
            System.out.println(attraction.getId() + ". " + attraction.getName() + " (₹" + ticketPrice + ")");
        }
    }
    public Visitor findVisitorByEmail(String email) {
        for(Visitor visitor : visitors) {
            if(visitor.getEmail().equals(email)) {
                return visitor;
            }
        }
        return null;
    }
    public void removeEvent(Event event) {
        events.remove(event);
    }
    public Event findEventByAttraction(Attraction attraction) {
        for (Event event : events) {
            if (event.getAttraction() == attraction) {
                return event;
            }
        }
        return null;
    }
    public void addEvent(Event event) {
        events.add(event);
    }
    public void removeAttraction(Attraction attraction) {
        if (attractions.contains(attraction)) {
            attractions.remove(attraction);
            System.out.println("Attraction removed successfully.");
        } else {
            System.out.println("Attraction not found.");
        }
    }
    public void  removeAnimal(Animal animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            System.out.println("Animal removed successfully.");
        } else {
            System.out.println("Attraction not found.");
        }
    }
    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }
    public List<Attraction> getAttractions() {
        return attractions;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
    public List<Visitor> getVisitors() {
        return visitors;
    }
    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
    public Discount findDiscountByCategory (String category) {
        for (Discount discount : discounts) {
            if (discount.getCategory() == category) {
                return discount;
            }
        }
        return null;
    }
    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }
    public void removeDiscount(Discount discount) {
        discounts.remove(discount);
    }
    public void addSpecialDeal(SpecialDeal specialDeal) {
        specialDeals.add(specialDeal);
    }
    public SpecialDeal findSpecialDealByCount(int attractionCount) {
        for(SpecialDeal specialDeal : specialDeals) {
            if(specialDeal.getRequiredAttractionCount() == attractionCount) {
                return specialDeal;
            }
        }
        return null;
    }
    public void removeSpecialDeal(SpecialDeal specialDeal) {
        specialDeals.remove(specialDeal);
    }
    public int getTotalVisitors() {
        return visitors.size();
    }
    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (Visitor visitor : visitors) {
            totalRevenue += visitor.getBalance();
        }
        return totalRevenue;
    }
    public Attraction getMostPopularAttraction() {
        if (attractions.isEmpty()) {
            return null;
        }

        Attraction mostPopular = attractions.get(0);
        for (Attraction attraction : attractions) {
            if (attraction.getVisitorCount() > mostPopular.getVisitorCount()) {
                mostPopular = attraction;
            }
        }
        return mostPopular;
    }

}

package org.example;

import java.util.*;

class Admin {
    private Zoo zoo;
    public Admin(Zoo zoo) {
        this.zoo = zoo;
    }

    public void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deals");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageAttractions(scanner);
                case 2 -> manageAnimals(scanner);
                case 3 -> scheduleEvents(scanner);
                case 4 -> setDiscounts(scanner);
                case 5 -> setSpecialDeals(scanner);
                case 6 -> viewVisitorStats();
                case 7 -> viewFeedback();
                case 8 -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private Attraction findAttractionById(int id) {
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getId() == id) {
                return attraction;
            }
        }
        return null;
    }
    private void manageAttractions(Scanner scanner) {
        while (true) {
            System.out.println("\nManage Attractions:");
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Attraction Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Attraction Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter the TicketPrice :");
                    long ticketPrice = scanner.nextLong();
                    Attraction attraction = new Attraction(name, description, ticketPrice);
                    zoo.addAttraction(attraction);
                    System.out.println("Attraction added successfully.");
                }
                case 2 -> {
                    List<Attraction> attractions = zoo.getAttractions();
                    System.out.println("Attractions in the Zoo:");
                    for (Attraction a : attractions) {
                        System.out.println("ID->" + a.getId() + ". " + a.getDescription());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Attraction ID to Modify: ");
                    int modifyId = scanner.nextInt();
                    scanner.nextLine();
                    Attraction existingAttraction = findAttractionById(modifyId);
                    if (existingAttraction != null) {
                        System.out.print("Enter New Attraction Name (or leave empty to keep current): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            existingAttraction.setName(newName);
                        }
                        System.out.print("Enter New price (or leave empty to keep current): ");
                        long newPrice = -1;
                        newPrice = scanner.nextLong();
                        if (newPrice != -1) {
                            existingAttraction.setName(newName);
                        }
                        System.out.print("Enter New Attraction Description (or leave empty to keep current): ");
                        String newDescription = scanner.nextLine();
                        if (!newDescription.isEmpty()) {
                            existingAttraction.setDescription(newDescription);
                        }

                        System.out.println("Attraction modified successfully.");
                    } else {
                        System.out.println("Attraction not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter the Attraction ID to Remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    Attraction removedAttraction = findAttractionById(removeId);
                    if (removedAttraction != null) {
                        zoo.removeAttraction(removedAttraction);
//                        attractionIds.remove(Integer.valueOf(removedAttraction.getId()));
                        System.out.println("Attraction removed successfully.");
                    } else {
                        System.out.println("Attraction not found.");
                    }
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private Animal findAnimalById(int id) {
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }
    private void manageAnimals(Scanner scanner) {
        while (true) {
            System.out.println("\nManage Animals:");
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal Details");
            System.out.println("3. Remove Animal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Animal Name: ");
                    String animalName = scanner.nextLine();
                    List<Animal> animals = zoo.getAnimals();
                    for (Animal animal : animals) {
                        if(animal.getName().equals(animalName)) {
                            System.out.println("Its exist. You have to update this Animal");
                            return;
                        }
                    }
                    System.out.print("Enter Animal Type (Mammal/Amphibian/Reptile): ");
                    String animalType = scanner.nextLine();
                    if (!animalType.equals("Mammal") && !animalType.equals("Amphibian") && !animalType.equals("Reptile")) {
                        System.out.println("Invalid animal type. Please choose Mammal, Amphibian, or Reptile.");
                        break;
                    }
                    Animal animal = new Animal(animalName, animalType);
                    zoo.addAnimal(animal);
                    System.out.println("Animal added to the zoo.");
                }
                case 2 -> {
                    System.out.print("Enter the Animal ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Animal existingAnimal = findAnimalById(updateId);
                    if (existingAnimal != null) {
                        System.out.print("Enter New Animal Name : ");
                        String newAnimalName = scanner.nextLine();
                        if (!newAnimalName.isEmpty()) {
                            existingAnimal.setName(newAnimalName);
                        } else {
                            System.out.println("You enter nothing.");
                            break;
                        }
                        System.out.print("Enter New Animal Type : ");
                        String newAnimalType = scanner.nextLine();

                        if (!newAnimalType.isEmpty() &&
                                !newAnimalType.equals("Mammal") &&
                                !newAnimalType.equals("Amphibian") &&
                                !newAnimalType.equals("Reptile")) {
                            System.out.println("Invalid animal type. Please choose Mammal, Amphibian, or Reptile.");
                            break;
                        }

                        if (!newAnimalType.isEmpty()) {
                            existingAnimal.setType(newAnimalType);
                        }
                        System.out.println("Animal details updated successfully.");
                    } else {
                        System.out.println("Animal not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Animal ID to Remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    Animal removedAnimal = findAnimalById(removeId);
                    if (removedAnimal != null) {
                        zoo.removeAnimal(removedAnimal);
                        System.out.println("Animal removed from the zoo.");
                    } else {
                        System.out.println("Animal not found.");
                    }
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void scheduleEvents(Scanner scanner) {
        while (true) {
            System.out.println("\nSchedule Events: ");
            System.out.println("1. Add Event");
            System.out.println("2. Modify Event Details");
            System.out.println("3. Remove Event");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Attraction ID for the Event: ");
                    int attractionId = scanner.nextInt();
                    scanner.nextLine();
                    Attraction attraction = findAttractionById(attractionId);

                    if (attraction != null) {
                        System.out.print("Enter Opening Time (e.g., 09:00 AM): ");
                        String openingTime = scanner.nextLine();
                        System.out.print("Enter Closing Time (e.g., 05:00 PM): ");
                        String closingTime = scanner.nextLine();
                        System.out.print("Enter Ticket Price: $");
                        double ticketPrice = scanner.nextDouble();
                        scanner.nextLine();

                        Event event = new Event(attraction, openingTime, closingTime, ticketPrice);
                        zoo.addEvent(event);
                        System.out.println("Event scheduled successfully for " + attraction.getName());
                    } else {
                        System.out.println("Attraction not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the Attraction ID for the Event to Modify: ");
                    // check here if this will not run:
                    attractionId = scanner.nextInt();
                    scanner.nextLine();
                    //check here if this will not run:
                    attraction = findAttractionById(attractionId);

                    if (attraction != null) {
                        Event existingEvent = zoo.findEventByAttraction(attraction);
                        if (existingEvent != null) {
                            System.out.print("Enter New Opening Time (or leave empty to keep current): ");
                            String newOpeningTime = scanner.nextLine();
                            if (!newOpeningTime.isEmpty()) {
                                existingEvent.setOpeningTime(newOpeningTime);
                            }
                            System.out.print("Enter New Closing Time (or leave empty to keep current): ");
                            String newClosingTime = scanner.nextLine();
                            if (!newClosingTime.isEmpty()) {
                                existingEvent.setClosingTime(newClosingTime);
                            }
                            System.out.print("Enter New Ticket Price (or leave empty to keep current): $");
                            String ticketPriceInput = scanner.nextLine();
                            if (!ticketPriceInput.isEmpty()) {
                                double newTicketPrice = Double.parseDouble(ticketPriceInput);
                                existingEvent.setTicketPrice(newTicketPrice);
                            }
                            System.out.println("Event details updated successfully.");
                        } else {
                            System.out.println("Event for the attraction not found.");
                        }
                    } else {
                        System.out.println("Attraction not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Attraction ID for the Event to Remove: ");
                    int attractionIdToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Attraction attractionToRemove = findAttractionById(attractionIdToRemove);

                    if (attractionToRemove != null) {
                        Event eventToRemove = zoo.findEventByAttraction(attractionToRemove);

                        if (eventToRemove != null) {
                            zoo.removeEvent(eventToRemove);
                            System.out.println("Event removed successfully for " + attractionToRemove.getName());
                        } else {
                            System.out.println("Event for the attraction not found.");
                        }
                    } else {
                        System.out.println("Attraction not found.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void setDiscounts(Scanner scanner) {
        while (true) {
            System.out.println("\nSet Discounts:");
            System.out.println("1. Add Discount");
            System.out.println("2. Modify Discount");
            System.out.println("3. Remove Discount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Discount Category (e.g., Students): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                    double percentage = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Discount Code (e.g., MINOR10): ");
                    String code = scanner.nextLine();

                    Discount discount = new Discount(category, percentage, code);
                    zoo.addDiscount(discount);
                    System.out.println("Discount added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the Discount Category to Update: ");
                    String categoryToUpdate = scanner.nextLine();
                    Discount existingDiscount = zoo.findDiscountByCategory(categoryToUpdate);

                    if (existingDiscount != null) {
                        System.out.print("Enter New Discount Percentage (or leave empty to keep current): ");
                        String newPercentageInput = scanner.nextLine();

                        if (!newPercentageInput.isEmpty()) {
                            double newPercentage = Double.parseDouble(newPercentageInput);
                            existingDiscount.setPercentage(newPercentage);
                        }
                        System.out.println("Discount details updated successfully.");
                    } else {
                        System.out.println("Discount category not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Discount Category to Remove: ");
                    String categoryToRemove = scanner.nextLine();
                    Discount discountToRemove = zoo.findDiscountByCategory(categoryToRemove);

                    if (discountToRemove != null) {
                        zoo.removeDiscount(discountToRemove);
                        System.out.println("Discount removed successfully for " + categoryToRemove);
                    } else {
                        System.out.println("Discount category not found.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void setSpecialDeals(Scanner scanner) {
        while (true) {
            System.out.println("\nSet Special Deals:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. Modify Special Deal");
            System.out.println("3. Remove Special Deal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Required Attraction Count: ");
                    int attractionCount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Discount Percentage (e.g., 15 for 15%): ");
                    double discountPercentage = scanner.nextDouble();
                    scanner.nextLine();

                    SpecialDeal specialDeal = new SpecialDeal(attractionCount, discountPercentage);
                    zoo.addSpecialDeal(specialDeal);
                    System.out.println("Special Deal added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the Required Attraction Count to Update: ");
                    int countToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    SpecialDeal existingSpecialDeal = zoo.findSpecialDealByCount(countToUpdate);

                    if (existingSpecialDeal != null) {
                        System.out.print("Enter New Discount Percentage (or leave empty to keep current): ");
                        String newPercentageInput = scanner.nextLine();

                        if (!newPercentageInput.isEmpty()) {
                            double newPercentage = Double.parseDouble(newPercentageInput);
                            existingSpecialDeal.setDiscountPercentage(newPercentage);
                        }
                        System.out.println("Special Deal details updated successfully.");
                    } else {
                        System.out.println("Special Deal with the required attraction count not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Required Attraction Count to Remove Special Deal: ");
                    int countToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    SpecialDeal specialDealToRemove = zoo.findSpecialDealByCount(countToRemove);

                    if (specialDealToRemove != null) {
                        zoo.removeSpecialDeal(specialDealToRemove);
                        System.out.println("Special Deal removed successfully for the required attraction count: " + countToRemove);
                    } else {
                        System.out.println("Special Deal with the required attraction count not found.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void viewVisitorStats() {
        int totalVisitors = zoo.getTotalVisitors();
        double totalRevenue = zoo.getTotalRevenue();
        Attraction mostPopularAttraction = zoo.getMostPopularAttraction();

        System.out.println("\nVisitor Statistics:");
        System.out.println("- Total Visitors: " + totalVisitors);
        System.out.println("- Total Revenue: $" + totalRevenue);
        if (mostPopularAttraction != null) {
            System.out.println("- Most Popular Attraction: " + mostPopularAttraction.getName());
        } else {
            System.out.println("- Most Popular Attraction: No data available.");
        }
    }
    private void viewFeedback() {
        System.out.println("Feedbacks are :");
        for(Feedback feedback : zoo.getFeedbacks()) {
            System.out.println(feedback.getText());
        }
    }

}

class VisitorApp {
    public void visitorAppMenu(Zoo zoo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to ZOUtopia!");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerVisitor(scanner, zoo);
                    break;
                case 2:
                    Visitor loggedInVisitor = loginVisitor(scanner, zoo);
                    if (loggedInVisitor != null) {
                        visitorMenu(scanner, loggedInVisitor, zoo);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void registerVisitor(Scanner scanner, Zoo zoo) {
        System.out.println("\nVisitor Registration:");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your PhoneNo.: ");
        String PhoneNo = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Money to add : ");
        int money = scanner.nextInt();

        Visitor visitor = new Visitor(name, age, PhoneNo, email, password, money);
        zoo.addVisitor(visitor);

        System.out.println("Registration is successful. Welcome, " + name + "! with email Id :" + visitor.getEmail());

    }

    public Visitor loginVisitor(Scanner scanner, Zoo zoo) {
        System.out.println("\nVisitor Login:");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Visitor visitor = zoo.findVisitorByEmail(email);

        if (visitor != null && visitor.getPassword().equals(password)) {
            System.out.println("Login Successful. Welcome back, " + visitor.getName() + "!");
            return visitor;
        } else {
            System.out.println("Login Failed. Invalid email or password.");
            return null;
        }
    }

    public void visitorMenu(Scanner scanner, Visitor visitor, Zoo zoo) {
        System.out.println("\nVisitor Menu - Welcome, " + visitor.getName() + "!");

        while (true) {
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Log Out");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    exploreZoo(zoo, scanner);
                    break;
                case 2:
                    buyMembership(scanner, visitor, zoo);
                    break;
                case 3:
                    buyTickets(visitor, zoo, scanner);
                    break;
                case 4:
                    viewDiscounts(zoo);
                    break;
                case 5:
                    viewSpecialDeals(zoo);
                    break;
                case 6:
                    visitAnimals(zoo, scanner);
                    break;
                case 7:
                    visitAttractions(visitor, zoo, scanner);
                    break;
                case 8:
                    leaveFeedback(visitor, zoo, scanner);
                    break;
                case 9:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void visitAttractions(Visitor visitor, Zoo zoo, Scanner scanner) {
        System.out.println("Visit Attractions:");
        List<Attraction> attractions = zoo.getAttractions();
        String membershipType = visitor.getMembershipType();

        if (attractions.isEmpty()) {
            System.out.println("No attractions are available at the moment.");
            return;
        }

        System.out.println("Attractions in the Zoo:");
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getId() + ". " + attraction.getName() + " (" + attraction.getDescription() + ")");
        }

        System.out.print("Enter the ID of the attraction you want to visit (or 0 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) {
            return;
        }

        Attraction selectedAttraction = findAttractionById(attractions, choice);

        if (selectedAttraction != null) {
            if (membershipType.equals("Premium") || visitor.hasTicketForAttraction(selectedAttraction)) {
                System.out.println("Welcome to " + selectedAttraction.getName() + ". Enjoy your visit!");
            } else {
                System.out.println("Ticket not available. Basic Members need to buy a separate ticket for the attractions.");
            }
        } else {
            System.out.println("Invalid attraction ID. Please try again.");
        }
    }
    public Attraction findAttractionById(List<Attraction> attractions, int Id) {
        for (Attraction attraction : attractions) {
            if(attraction.getId() == Id) {
                return attraction;
            }
        }
        return null;
    }
    public void leaveFeedback(Visitor visitor, Zoo zoo, Scanner scanner) {
        System.out.println("Leave Feedback:");
        System.out.print("Enter your feedback (max 200 characters): ");
        String feedback = scanner.nextLine();

        if (feedback.length() > 200) {
            System.out.println("Feedback is too long. Please keep it within 200 characters.");
            return;
        }

        zoo.addFeedback(visitor, feedback);
        System.out.println("Thank you for your feedback.");
    }
    public void viewSpecialDeals(Zoo zoo) {
        System.out.println("View Special Deals:");
        List<SpecialDeal> specialDeals = zoo.getSpecialDeals();

        if (specialDeals.isEmpty()) {
            System.out.println("No special deals are currently available.");
        } else {
            System.out.println("Available Special Deals:");

            for (SpecialDeal specialDeal : specialDeals) {
                System.out.println("Deal: Buy " + specialDeal.getRequiredAttractionCount() + " attractions and get " +
                        specialDeal.getDiscountPercentage() + "% off");
            }
        }
    }
    public void viewDiscounts(Zoo zoo) {
        System.out.println("View Discounts:");
        List<Discount> discounts = zoo.getDiscounts();

        if (discounts.isEmpty()) {
            System.out.println("No discounts are currently available.");
        } else {
            System.out.println("Available Discounts:");

            for (Discount discount : discounts) {
                System.out.println(discount.getDescription() + " - " + discount.getDiscountCode());
            }
        }
    }
    public void buyTickets(Visitor visitor, Zoo zoo, Scanner scanner) {
        if (visitor.getMembershipType().equals("Premium")) {
            System.out.println("You don't have to buy Tickets because you have Premium memberShip");
            return;
        }
        System.out.println("Buy Tickets:");
        List<Attraction> attractions = zoo.getAttractions();

        if (attractions.isEmpty()) {
            System.out.println("No attractions available to purchase tickets for.");
            return;
        }

        while (true) {
            System.out.println("Select an Attraction to Buy a Ticket:");
            zoo.ticketPrice();
            System.out.println((attractions.size() + 1) + ". Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= attractions.size()) {
                Attraction selectedAttraction = attractions.get(choice-1);
                viewDiscounts(zoo);
                System.out.print("Enter code here or empty for no code:");
                String code = scanner.nextLine();
                List<Discount> discounts = zoo.getDiscounts();

                double ticketPrice = selectedAttraction.getTicketPrice();
                for (Discount discount : discounts) {
                    if (discount.getDiscountCode().equals(code)) {
                        ticketPrice = selectedAttraction.applyDiscount(ticketPrice);
                        System.out.println("After discount ticket price :" + ticketPrice);
                        break;
                    }
                }

                List<SpecialDeal> specialDeals = zoo.getSpecialDeals();
                for (SpecialDeal specialDeal : specialDeals) {
                    if(specialDeal.getRequiredAttractionCount()-1 == visitor.getTicketCount()) {
                        ticketPrice = specialDeal.applyDiscount(ticketPrice);
                        System.out.println("After Special discount ticket price :" + ticketPrice);
                        break;
                    }
                }

                if (visitor.getBalance() >= ticketPrice) {
                    visitor.buyTicket(selectedAttraction, ticketPrice);
                    System.out.println("Your balance is now ₹" + visitor.getBalance());
                } else {
                    System.out.println("Insufficient balance to purchase the ticket.");
                }
            } else if (choice == attractions.size() + 1) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void buyMembership(Scanner scanner, Visitor visitor, Zoo zoo) {
        System.out.println("Buy Membership:");
        System.out.println("1. Basic Membership (₹20)");
        System.out.println("2. Premium Membership (₹50)");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                if (visitor.getBalance() >= 20) {
                    visitor.buyMembership("Basic", 20);
                    System.out.println("Basic Membership purchased successfully. Your balance is now ₹" + visitor.getBalance());
                } else {
                    System.out.println("Insufficient balance to purchase Basic Membership.");
                }
                break;
            case 2:
                if (visitor.getBalance() >= 50) {
                    visitor.buyMembership("Premium", 50);
                    System.out.println("Premium Membership purchased successfully. Your balance is now ₹" + visitor.getBalance());
                } else {
                    System.out.println("Insufficient balance to purchase Premium Membership.");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public void exploreZoo(Zoo zoo, Scanner scanner) {
        System.out.println("Explore the Zoo:");
        System.out.println("1. View Attractions");
        System.out.println("2. View Animals");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAttractions(zoo, scanner);
                break;
            case 2:
                viewAnimals(zoo);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void viewAttractions(Zoo zoo, Scanner scanner) {
        List<Attraction> attractions = zoo.getAttractions();
        System.out.println("\nAttractions in the Zoo:");
        for (Attraction attraction : attractions) {
            System.out.println("ID " + attraction.getId() + ". " + attraction.getName());
        }
        System.out.println("Enter your choice ID no. :");
        int index = scanner.nextInt();
        System.out.println(attractions.get(index-1).getDescription());
    }

    public void viewAnimals(Zoo zoo) {
        List<Animal> animals = zoo.getAnimals();
        System.out.println("\nAnimals in the Zoo:");
        for (Animal animal : animals) {
            System.out.println(animal.getId() + ". " + animal.getName());
        }
    }
    public void visitAnimals(Zoo zoo, Scanner scanner) {
        System.out.println("Visit Animals:");
        List<Animal> animals = zoo.getAnimals();

        if (animals.isEmpty()) {
            System.out.println("No animals to visit.");
            return;
        }

        while (true) {
            System.out.println("Select an Animal to Visit:");
            for (Animal animal : animals) {
                System.out.println(animal.getId() + ". " + animal.getName() + " (" + animal.getType() + ")");
            }
            System.out.println((animals.size() + 1) + ". Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 0 && choice <= animals.size()) {
                Animal selectedAnimal = animals.get(choice - 1);

                System.out.println("You are visiting " + selectedAnimal.getName() + " (" + selectedAnimal.getType() + ").");
                System.out.println("Choose an action:");
                System.out.println("1. Feed the animal");
                System.out.println("2. Read about the animal");
                System.out.println("3. Exit");

                int actionChoice = scanner.nextInt();
                scanner.nextLine();

                if (actionChoice == 1) {
                    System.out.println(selectedAnimal.feed());
                } else if (actionChoice == 2) {
                    System.out.println(selectedAnimal.readAbout());
                } else if (actionChoice == 3) {
                    return;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == animals.size() + 1) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("Welcome to ZOUtopia!\n");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("\nEnter Admin Username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter Admin Password: ");
                String adminPassword = scanner.nextLine();
                if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
                    Admin admin = new Admin(zoo);
                    admin.adminMenu(scanner);
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } else if (choice == 2) {
                VisitorApp visitor = new VisitorApp();
                visitor.visitorAppMenu(zoo);
            } else if (choice == 3) {
                System.out.println("View Special Deals:");

                List<SpecialDeal> specialDeals = zoo.getSpecialDeals();

                if (!specialDeals.isEmpty()) {
                    for (SpecialDeal specialDeal : specialDeals) {
                        System.out.println("Required Attraction count : " + specialDeal.getRequiredAttractionCount() + " and Discount(%): " + specialDeal.getDiscountPercentage());
                    }
                }
                else {
                    System.out.println("No Special Discounts currently Present");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
