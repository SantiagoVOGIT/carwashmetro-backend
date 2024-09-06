CREATE TABLE _user (
                       id UUID PRIMARY KEY,
                       first_name VARCHAR(40) NOT NULL,
                       last_name VARCHAR(40) NOT NULL,
                       dni_type VARCHAR NOT NULL,
                       dni_number VARCHAR(10) NOT NULL,
                       phone_number VARCHAR(10),
                       email VARCHAR(254) NOT NULL UNIQUE,
                       status VARCHAR NOT NULL,
                       role VARCHAR NOT NULL,
                       created_at TIMESTAMP NOT NULL
);

CREATE TABLE _vehicle (
                          id UUID PRIMARY KEY,
                          user_id UUID NOT NULL,
                          license_plate VARCHAR(9) NOT NULL UNIQUE,
                          model VARCHAR(50) NOT NULL,
                          vehicle_type VARCHAR NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES _user(id)
);

CREATE TABLE _cell (
                       id UUID PRIMARY KEY,
                       space_number VARCHAR NOT NULL UNIQUE,
                       vehicle_type VARCHAR NOT NULL,
                       status VARCHAR NOT NULL,
                       created_at TIMESTAMP NOT NULL
);

CREATE TABLE _reservation (
                              id UUID PRIMARY KEY,
                              user_id UUID NOT NULL,
                              cell_id UUID NOT NULL,
                              vehicle_id UUID NOT NULL,
                              reservation_code VARCHAR(10) UNIQUE,
                              status VARCHAR NOT NULL,
                              start_time TIMESTAMP,
                              end_time TIMESTAMP,
                              created_at TIMESTAMP NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES _user(id),
                              FOREIGN KEY (cell_id) REFERENCES _cell(id),
                              FOREIGN KEY (vehicle_id) REFERENCES _vehicle(id)
);

CREATE TABLE _employee (
                           id UUID PRIMARY KEY,
                           user_id UUID NOT NULL,
                           position VARCHAR NOT NULL,
                           salary INTEGER NOT NULL,
                           status VARCHAR NOT NULL,
                           created_at TIMESTAMP NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES _user(id)
);