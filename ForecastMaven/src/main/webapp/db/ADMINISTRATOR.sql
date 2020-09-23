/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hazel
 * Created: 2020. 9. 23
 */


DROP TABLE ADMINISTRATOR;

CREATE TABLE ADMINISTRATOR (
    ADMINID INTEGER,
    ADMINPASSWORD VARCHAR (40),
    EMAIL VARCHAR (40),
    FIRSTNAME VARCHAR (40),
    LASTNAME VARCHAR (40) 
);

INSERT INTO ADMINISTRATOR (ADMINID, ADMINPASSWORD, EMAIL, FIRSTNAME, LASTNAME)
VALUES (1, 'sy0827', 'syong0195@gmail.com', 'Soyoung', 'Kim');