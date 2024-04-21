
DROP DATABASE IF EXISTS recipe;
CREATE DATABASE recipe;
USE recipe;

CREATE TABLE Recipe (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    ingredient VARCHAR(255) NOT NULL,
    price VARCHAR(50) NOT NULL
);

CREATE TABLE MyRecipe (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ingredient VARCHAR(255) NOT NULL,
    price VARCHAR(50) NOT NULL
);

-- Insert data into Recipe table
INSERT INTO Recipe (name, ingredient, price) VALUES
    ('Lemon Rice', 'Rice, Lemon, Salt, Pepper', '100'),
    ('Sambar', 'Garam Masala, Sambar Powder, Water, Salt', '200'),
    ('Pizza', 'Maida, Yeast, Water, Salt, Tomato, Basil', '200'),
    ('Chapati', 'Wheat, Water, Oil, Salt', '100'),
    ('Cornflakes', 'Cornflakes, Milk', '250');


CREATE TABLE Ingredient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    qty VARCHAR(255) NOT NULL,
    price VARCHAR(50) NOT NULL
);

CREATE TABLE MyIngredient (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    qty VARCHAR(255) NOT NULL,
    price VARCHAR(50) NOT NULL
);

-- Insert data into Ingredient table
INSERT INTO Ingredient (name, qty, price) VALUES
    ('Rice', '2', '70'),
    ('Wheat', '3', '100'),
    ('Milk', '4', '20'),
    ('Oil', '2', '600'),
    ('Salt', '1', '150');
