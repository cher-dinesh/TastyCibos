# Food Delivery Web Application

This is a full-stack food delivery web application built using Java, JSP, Hibernate, and Bootstrap. The application allows users to browse menus, add items to the cart, and place orders. Admins can manage restaurant listings, including adding, modifying, and deleting restaurant details.

## Features

### User Side
- **Browse Restaurants:** View a list of restaurants, each with details such as name, address, delivery time, and cuisine type.
- **Menu Display:** See the menu items for each restaurant, with options to add items directly to the cart.
- **Cart Management:** Add items to the cart and update item quantities dynamically without reloading the page.
- **Order Placement:** Place an order with selected items from the cart.
- **Profile Management:** Users can view their order history and update their account details.
  
### Admin Side
- **Restaurant Management:** Admins can add new restaurants, modify existing ones, or delete them from the database.
- **Image Upload:** Admins can upload images for restaurants, with images stored in the project directory and paths saved in the database.

### Technology Stack
- **Frontend:** HTML, CSS, JavaScript, Bootstrap for responsive design.
- **Backend:** Java (Servlets and JSP), Hibernate for ORM.
- **Database:** MySQL.
- **Tools:** Maven, Git for version control.

## Installation

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/yourusername/food-delivery-app.git
    ```

2. Navigate to the project directory:
    ```bash
    cd food-delivery-app
    ```

3. Import the project into your preferred IDE (e.g., Eclipse or IntelliJ).

4. Set up the database:
   - Create a MySQL database and import the provided SQL schema.
   - Update the database connection details in the `hibernate.cfg.xml` file.

5. Build the project using Maven:
    ```bash
    mvn clean install
    ```

6. Deploy the application on a servlet container (e.g., Apache Tomcat).

## Usage

- **User Flow:**
    1. Register an account or log in as an existing user.
    2. Browse restaurants and add items to your cart.
    3. View your cart and proceed to checkout.
    4. View your order history and update your profile information.
  
- **Admin Flow:**
    1. Log in as an admin.
    2. Manage restaurant listings (add, edit, or delete restaurants).
    3. Upload restaurant images to enhance restaurant pages.

## Key Files and Directories

- `/src/main/java/`: Contains all Java code, including Servlets and Hibernate DAO implementations.
- `/src/main/webapp/`: Contains JSP pages and static assets (CSS, JS).
- `/src/main/resources/hibernate.cfg.xml`: Hibernate configuration file for connecting to the MySQL database.
- `/src/main/webapp/uploads/`: Directory where uploaded restaurant images are stored.

## Future Improvements

- Add real-time order tracking.
- Implement payment gateway integration.
- Improve restaurant and menu search functionality with filters.


## Contributing

1. Fork the repository.
2. Create your feature branch:
    ```bash
    git checkout -b feature/YourFeature
    ```
3. Commit your changes:
    ```bash
    git commit -m 'Add some feature'
    ```
4. Push to the branch:
    ```bash
    git push origin feature/YourFeature
    ```
5. Submit a pull request.
