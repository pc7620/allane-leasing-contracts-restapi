CREATE TABLE customer (
    id VARCHAR(36) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birthDate DATE
);

CREATE TABLE vehicle (
    id VARCHAR(36) PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    model_year INTEGER NOT NULL,
    vin VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE leasing_contract (
    id VARCHAR(36) PRIMARY KEY,
    contract_number VARCHAR(255) NOT NULL,
    monthly_rate DECIMAL(10, 2) NOT NULL,
    customer_id VARCHAR(36),
    vehicle_id VARCHAR(36),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);
