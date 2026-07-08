CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER
);
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER,
    Performance VARCHAR2(20)
);
INSERT INTO Customers VALUES (1,'John',65,15000,'FALSE');
INSERT INTO Customers VALUES (2,'Alice',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'David',70,12000,'FALSE');

COMMIT;
INSERT INTO Loans VALUES (101,1,8.5,SYSDATE+20);
INSERT INTO Loans VALUES (102,2,9.0,SYSDATE+40);
INSERT INTO Loans VALUES (103,3,7.5,SYSDATE+15);

COMMIT;
INSERT INTO Accounts VALUES (1001,1,'Savings',5000);
INSERT INTO Accounts VALUES (1002,2,'Savings',8000);
INSERT INTO Accounts VALUES (1003,3,'Savings',12000);

COMMIT;
INSERT INTO Employees VALUES (1,'Raj','IT',50000,'Excellent');
INSERT INTO Employees VALUES (2,'Ravi','HR',45000,'Good');
INSERT INTO Employees VALUES (3,'Priya','IT',55000,'Excellent');

COMMIT;
SELECT * FROM Customers;
BEGIN

    FOR c IN (SELECT * FROM Customers)
    LOOP

        IF c.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Updated Loan for ' || c.Name);

        END IF;

    END LOOP;

    COMMIT;

END;
/
SELECT * FROM Loans;
SELECT * FROM Customers;
UPDATE Loans
SET InterestRate = 8.5
WHERE LoanID = 101;

UPDATE Loans
SET InterestRate = 9
WHERE LoanID = 102;

UPDATE Loans
SET InterestRate = 7.5
WHERE LoanID = 103;

COMMIT;
select * from Loans;

BEGIN

    FOR c IN (SELECT * FROM Customers)
    LOOP

        IF c.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE(c.Name || ' promoted to VIP');

        END IF;

    END LOOP;

    COMMIT;

END;
/
SELECT * FROM Customers;
BEGIN

    FOR l IN (
        SELECT c.Name, lo.DueDate
        FROM Customers c
        JOIN Loans lo
        ON c.CustomerID = lo.CustomerID
        WHERE lo.DueDate <= SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan for '
            || l.Name ||
            ' is due on '
            || TO_CHAR(l.DueDate, 'DD-MON-YYYY')
        );

    END LOOP;

END;
/
SELECT * FROM Accounts;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

END;
/
EXEC ProcessMonthlyInterest;
SELECT * FROM Accounts;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus updated successfully.');

END;
/
EXEC UpdateEmployeeBonus('IT',10);
SELECT * FROM Employees;
EXEC TransferFunds(1001,1002,1000);
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest;
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/
EXEC TransferFunds(1001,1002,1000);