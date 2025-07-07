import java.util.ArrayList;
import java.util.Scanner;

public class SocialMediaFriendConnections {
    static class UserNode {
        int userId;
        String name;
        int age;
        ArrayList<Integer> friendIds;
        UserNode next;

        public UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
            this.next = null;
        }
    }

    static class UserLinkedList {
        UserNode head;

        public void addUser(int userId, String name, int age) {
            if (findUserById(userId) != null) {
                System.out.println("User ID already exists.");
                return;
            }
            UserNode newNode = new UserNode(userId, name, age);
            newNode.next = head;
            head = newNode;
            System.out.println("User added successfully.");
        }

        public UserNode findUserById(int userId) {
            UserNode temp = head;
            while (temp != null) {
                if (temp.userId == userId) return temp;
                temp = temp.next;
            }
            return null;
        }

        public void addFriendConnection(int userId1, int userId2) {
            if (userId1 == userId2) {
                System.out.println("Cannot add self as friend.");
                return;
            }
            UserNode user1 = findUserById(userId1);
            UserNode user2 = findUserById(userId2);
            if (user1 == null || user2 == null) {
                System.out.println("One or both users not found.");
                return;
            }
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name + ".");
        }

        public void removeFriendConnection(int userId1, int userId2) {
            UserNode user1 = findUserById(userId1);
            UserNode user2 = findUserById(userId2);
            if (user1 == null || user2 == null) {
                System.out.println("One or both users not found.");
                return;
            }
            boolean removed1 = user1.friendIds.remove((Integer)userId2);
            boolean removed2 = user2.friendIds.remove((Integer)userId1);
            if (removed1 && removed2) {
                System.out.println("Friend connection removed between " + user1.name + " and " + user2.name + ".");
            } else {
                System.out.println("No friend connection exists between the users.");
            }
        }

        public void displayFriends(int userId) {
            UserNode user = findUserById(userId);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }
            System.out.println("Friends of " + user.name + ":");
            if (user.friendIds.isEmpty()) {
                System.out.println("No friends found.");
                return;
            }
            for (int fid : user.friendIds) {
                UserNode friend = findUserById(fid);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (ID: " + friend.userId + ", Age: " + friend.age + ")");
                }
            }
        }

        public void findMutualFriends(int userId1, int userId2) {
            UserNode user1 = findUserById(userId1);
            UserNode user2 = findUserById(userId2);
            if (user1 == null || user2 == null) {
                System.out.println("One or both users not found.");
                return;
            }
            ArrayList<Integer> mutual = new ArrayList<>();
            for (int fid : user1.friendIds) {
                if (user2.friendIds.contains(fid)) mutual.add(fid);
            }
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
            if (mutual.isEmpty()) {
                System.out.println("No mutual friends.");
            } else {
                for (int fid : mutual) {
                    UserNode friend = findUserById(fid);
                    if (friend != null) {
                        System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
                    }
                }
            }
        }

        public void searchUserByName(String name) {
            UserNode temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(name)) {
                    System.out.println("User found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) System.out.println("No user found with name '" + name + "'.");
        }

        public void searchUserById(int userId) {
            UserNode user = findUserById(userId);
            if (user != null) {
                System.out.println("User found: " + user.name + " (ID: " + user.userId + ", Age: " + user.age + ")");
            } else {
                System.out.println("No user found with ID " + userId + ".");
            }
        }

        public void countFriendsForEachUser() {
            UserNode temp = head;
            while (temp != null) {
                System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.friendIds.size() + " friend(s).");
                temp = temp.next;
            }
        }

        public void displayAllUsers() {
            UserNode temp = head;
            System.out.println("All Users:");
            while (temp != null) {
                System.out.println("- " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserLinkedList users = new UserLinkedList();
        int choice;
        do {
            System.out.println("\nSocial Media Friend Connections");
            System.out.println("1. Add new user");
            System.out.println("2. Add friend connection");
            System.out.println("3. Remove friend connection");
            System.out.println("4. Find mutual friends");
            System.out.println("5. Display all friends of a user");
            System.out.println("6. Search user by Name");
            System.out.println("7. Search user by User ID");
            System.out.println("8. Count number of friends for each user");
            System.out.println("9. Display all users");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    users.addUser(userId, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int uid1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int uid2 = scanner.nextInt();
                    users.addFriendConnection(uid1, uid2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    int ruid1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int ruid2 = scanner.nextInt();
                    users.removeFriendConnection(ruid1, ruid2);
                    break;
                case 4:
                    System.out.print("Enter User ID 1: ");
                    int m1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int m2 = scanner.nextInt();
                    users.findMutualFriends(m1, m2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int fid = scanner.nextInt();
                    users.displayFriends(fid);
                    break;
                case 6:
                    System.out.print("Enter Name: ");
                    String sname = scanner.nextLine();
                    users.searchUserByName(sname);
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    int sid = scanner.nextInt();
                    users.searchUserById(sid);
                    break;
                case 8:
                    users.countFriendsForEachUser();
                    break;
                case 9:
                    users.displayAllUsers();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);
        scanner.close();
    }
}