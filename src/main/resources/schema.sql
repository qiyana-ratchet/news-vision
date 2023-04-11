DROP TABLE IF EXISTS ARTICLE;
CREATE TABLE ARTICLE
(
    id        INT          NOT NULL Primary Key AUTO_INCREMENT,
    title     VARCHAR(255) NOT NULL,
    reporter  VARCHAR(48)  NOT NULL,
    a_time    DATE         NOT NULL,
    article   CLOB         NOT NULL,
    p_article CLOB         NOT NULL,
    uri       VARCHAR(255)
);