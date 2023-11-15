import java.util.Scanner;
import dao.*;
import models.*;
import services.customer.CustomerService;
import services.customer.CustomerServiceImpl;
import services.order.OrderService;
import services.order.OrderServiceImpl;
import services.product.ProductService;
import services.product.ProductServiceImpl;
import services.transaction.TransactionService;
import services.transaction.TransactionServiceImpl;

public class App {
    static CustomerDao customerDao = new CustomerDao();
    static ProductDao productDao = new ProductDao();
    static TransactionDao transactionDao = new TransactionDao();
    static OrderDao orderDao = new OrderDao();

    static CustomerService customerService = new CustomerServiceImpl(customerDao);
    static ProductService productService = new ProductServiceImpl(productDao);
    static TransactionService transactionService = new TransactionServiceImpl(transactionDao);
    static OrderService orderService = new OrderServiceImpl(orderDao);

    private static void showMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Transaction");
        System.out.println("4. Order");
        System.out.print("Input menu: ");
    }

    private static void showCustomerMenu() {
        System.out.println("=== Customer Menu ===");
        System.out.println("1. Register Customer");
        System.out.println("2. Show All Customer");
        System.out.println("3. Show Customer By ID");
        System.out.print("Input menu: ");
    }

    private static void showProductMenu() {
        System.out.println("=== Product Menu ===");
        System.out.println("1. Register Product");
        System.out.println("2. Show All Product");
        System.out.println("3. Show Product By ID");
        System.out.print("Input menu: ");
    }

    private static void showTransactionMenu() {
        System.out.println("=== Transaction Menu ===");
        System.out.println("1. Register Transaction");
        System.out.println("2. Show All Transaction");
        System.out.println("3. Show Transaction By ID");
        System.out.print("Input menu: ");
    }

    private static void showOrderMenu() {
        System.out.println("=== Order Menu ===");
        System.out.println("1. Register Order");
        System.out.println("2. Show All Order");
        System.out.println("3. Show Order By ID");
        System.out.print("Input menu: ");
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Boolean retryMainMenu = true;
        Boolean retryPreviousMenu = true;

        try {
            do {
                showMainMenu();
                String mainOption = scanner.nextLine();

                switch (mainOption) {
                    case "1":
                        do {
                            showCustomerMenu();
                            String option = scanner.nextLine();

                            switch (option) {
                                case "1":
                                    System.out.println("=== Register Customer ===");

                                    System.out.print("First Name: ");
                                    String fname = scanner.nextLine();
                                    System.out.print("Last Name: ");
                                    String lname = scanner.nextLine();
                                    System.out.print("Email: ");
                                    String email = scanner.nextLine();

                                    Customer customer = new Customer(email);
                                    customer.setFirstName(fname);
                                    customer.setLastName(lname);

                                    customerService.registerCustomer(customer);
                                    break;

                                case "2":
                                    System.out.println("=== Show All Customer ===");
                                    customerService.showAllCustomer();
                                    break;

                                case "3":
                                    System.out.println("=== Show Customer By ID ===");

                                    customerService.showAllCustomer();

                                    System.out.print("Input ID: ");
                                    Integer id = Integer.parseInt(scanner.nextLine());
                                    customerService.showCustomerById(id);
                                    break;

                                default:
                                    System.out.println("Menu not found!");
                                    break;
                            }

                            while (true) {
                                System.out.print("Retry previous menu? (y/n): ");
                                String answer = scanner.nextLine();
                                if ("y".equalsIgnoreCase(answer)) {
                                    break;
                                } else if ("n".equalsIgnoreCase(answer)) {
                                    retryPreviousMenu = false;
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                    continue;
                                }
                            }
                        } while (retryPreviousMenu);
                        break;

                    case "2":
                        do {
                            showProductMenu();
                            String option = scanner.nextLine();

                            switch (option) {
                                case "1":
                                    System.out.println("=== Register Product ===");

                                    System.out.print("Product name: ");
                                    String productName = scanner.nextLine();
                                    System.out.print("Product description: ");
                                    String description = scanner.nextLine();
                                    System.out.print("Price: ");
                                    Double price = Double.parseDouble(scanner.nextLine());
                                    System.out.print("Quantity: ");
                                    Integer quantity = Integer.parseInt(scanner.nextLine());

                                    Product product = new Product(productName, price, quantity);
                                    product.setDescription(description);

                                    productService.registerProduct(product);
                                    break;

                                case "2":
                                    System.out.println("=== Show All Product ===");
                                    productService.showAllProduct();
                                    break;

                                case "3":
                                    System.out.println("=== Show Product By Id");

                                    productService.showAllProduct();

                                    System.out.print("Input ID: ");
                                    Integer id = Integer.parseInt(scanner.nextLine());
                                    productService.showProductById(id);
                                    break;

                                default:
                                    System.out.println("Menu not found!");
                                    break;
                            }

                            while (true) {
                                System.out.print("Retry previous menu? (y/n): ");
                                String answer = scanner.nextLine();
                                if ("y".equalsIgnoreCase(answer)) {
                                    break;
                                } else if ("n".equalsIgnoreCase(answer)) {
                                    retryPreviousMenu = false;
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                    continue;
                                }
                            }
                        } while (retryPreviousMenu);
                        break;

                    case "3":
                        do {
                            showTransactionMenu();
                            String option = scanner.nextLine();

                            switch (option) {
                                case "1":
                                    System.out.println("=== Register Transaction ===");

                                    System.out.print("Total amount: ");
                                    Double amount = Double.parseDouble(scanner.nextLine());
                                    customerService.showAllCustomer();
                                    System.out.print("Choose customer ID: ");
                                    Integer custId = Integer.parseInt(scanner.nextLine());
                                    Customer customer = customerService.getCustomerById(custId);
                                    System.out.print("Status: ");
                                    String status = scanner.nextLine();

                                    Transaction transaction = new Transaction(amount, customer);
                                    transaction.setStatus(status);

                                    transactionService.registerTransaction(transaction);
                                    break;

                                case "2":
                                    System.out.println("=== Show All Transaction ===");

                                    transactionService.showAllTransaction();
                                    break;

                                case "3":
                                    System.out.println("=== Show Transaction By ID ===");

                                    transactionService.showAllTransaction();

                                    System.out.print("Input ID: ");
                                    Integer id = Integer.parseInt(scanner.nextLine());
                                    transactionService.showTransactionById(id);

                                    break;

                                default:
                                    System.out.println("Menu not found!");
                                    break;
                            }

                            while (true) {
                                System.out.print("Retry previous menu? (y/n): ");
                                String answer = scanner.nextLine();
                                if ("y".equalsIgnoreCase(answer)) {
                                    break;
                                } else if ("n".equalsIgnoreCase(answer)) {
                                    retryPreviousMenu = false;
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                    continue;
                                }
                            }

                        } while (retryPreviousMenu);
                        break;

                    case "4":
                        do {
                            showOrderMenu();
                            String option = scanner.nextLine();

                            switch (option) {
                                case "1":
                                    System.out.println("=== Register Order ===");

                                    transactionService.showAllTransaction();
                                    System.out.print("Choose Transaction ID: ");
                                    Integer trxId = Integer.parseInt(scanner.nextLine());
                                    Transaction transaction =
                                            transactionService.getTransactionById(trxId);
                                    productService.showAllProduct();
                                    System.out.print("Choose Product ID: ");
                                    Integer prodId = Integer.parseInt(scanner.nextLine());
                                    Product product = productService.getProductById(prodId);
                                    System.out.print("Quantity: ");
                                    Integer quantity = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Price: ");
                                    Double price = Double.parseDouble(scanner.nextLine());

                                    Order order = new Order(transaction, product, quantity, price);

                                    orderService.registerOrder(order);
                                    break;

                                case "2":
                                    System.out.println("=== Show All Order ===");

                                    orderService.showAllOrder();
                                    break;

                                case "3":
                                    System.out.println("=== Show Product By ID ===");

                                    orderService.showAllOrder();

                                    System.out.print("Input ID: ");
                                    Integer id = Integer.parseInt(scanner.nextLine());
                                    orderService.showOrderById(id);

                                    break;

                                default:
                                    System.out.println("Menu not found!");
                                    break;
                            }

                            while (true) {
                                System.out.print("Retry previous menu? (y/n): ");
                                String answer = scanner.nextLine();
                                if ("y".equalsIgnoreCase(answer)) {
                                    break;
                                } else if ("n".equalsIgnoreCase(answer)) {
                                    retryPreviousMenu = false;
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                    continue;
                                }
                            }

                        } while (retryPreviousMenu);
                        break;

                    default:
                        System.out.println("Menu not found!");
                        break;
                }

                while (true) {
                    System.out.print("Retry main menu? (y/n): ");
                    String mainAnswer = scanner.nextLine();
                    if ("y".equalsIgnoreCase(mainAnswer)) {
                        break;
                    } else if ("n".equalsIgnoreCase(mainAnswer)) {
                        retryMainMenu = false;
                        break;
                    } else {
                        System.out.println("Wrong input!");
                        continue;
                    }
                }

            } while (retryMainMenu);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
