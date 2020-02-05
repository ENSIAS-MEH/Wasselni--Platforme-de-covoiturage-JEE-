create database wasselnidb;
use wasselnidb;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  wasselnidb
--

-- --------------------------------------------------------

--
-- Structure de la table users
--

DROP TABLE IF EXISTS questions;
CREATE TABLE IF NOT EXISTS questions (
                                           id_question bigint(20) NOT NULL,
                                           text_question varchar(500) NOT NULL,
                                           PRIMARY KEY ( id_question )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
                                     ID bigint(20) NOT NULL AUTO_INCREMENT,
                                     NOM varchar(50),
                                     PRENOM varchar(50),
                                     SEXE varchar(5),
                                     DATE_NAISSANCE date,
                                     REGION VARCHAR(50),
                                     LOGIN varchar(50),
                                     EMAIL varchar(50),
                                     PASSWORD varchar(255),
                                     IMAGE_PATH VARCHAR(200),
                                     DATE_INSCRIPTION datetime DEFAULT CURRENT_TIMESTAMP,
                                     RANK float DEFAULT '5',
                                     ACTIVATION int(11) DEFAULT '1',
                                     ID_QUESTION_USER bigint(20),
                                     PRIMARY KEY (ID),
                                     UNIQUE KEY LOGIN_UNIQUE (LOGIN),
                                     UNIQUE KEY EMAIL_UNIQUE (EMAIL),
                                     FOREIGN KEY (ID_QUESTION_USER) REFERENCES questions(id_question)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;


-- --------------------------------------------------------

--
-- Structure de la table trajet
--

DROP TABLE IF EXISTS trajet;
CREATE TABLE IF NOT EXISTS trajet (
                                      ID_TRAJET bigint(20) NOT NULL AUTO_INCREMENT,
                                      VILLE_DEPART varchar(100),
                                      QUARTIER_DEPART varchar(100),
                                      RUE_DEPART varchar(100),
                                      VILLE_DESTINATION varchar(100),
                                      QUARTIER_DESTINATION varchar(100),
                                      RUE_DESTINATION varchar(100),
                                      PRIMARY KEY (ID_TRAJET),
                                      UNIQUE KEY TRAJET_UNIQUE (VILLE_DEPART,QUARTIER_DEPART,RUE_DEPART,VILLE_DESTINATION,QUARTIER_DESTINATION,RUE_DESTINATION)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

-- --------------------------------------------------------

--
-- Structure de la table details_trajet
--

DROP TABLE IF EXISTS details_trajet;
CREATE TABLE IF NOT EXISTS details_trajet (
                                              ID_DETAILS_TRAJET BIGINT(20) NOT NULL AUTO_INCREMENT,
                                              DATETIME_DEPART datetime,
                                              PRIX_PLACE int(11),
                                              TYPE_VOITURE varchar(50),
                                              MODELE_VOITURE varchar(50),
                                              MARQUE_VOITURE varchar(50),
                                              CLIMATISATION_VOITURE int(11),
                                              EFFECTIF int(11),
                                              ID_TRAJET_CHOISIE BIGINT(20),
                                              PRIMARY KEY (ID_DETAILS_TRAJET),
                                              FOREIGN KEY (ID_TRAJET_CHOISIE) REFERENCES trajet(ID_TRAJET)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

-- --------------------------------------------------------

--
-- Structure de la table estassocie_a
--

DROP TABLE IF EXISTS estassocie_a;
CREATE TABLE IF NOT EXISTS estassocie_a (
                                            ID_DETAILS_TRAJET_ASSOCIE BIGINT(20) NOT NULL,
                                            ID_USER_ASSOCIE bigint(20) NOT NULL,
                                            TYPE_ASSOCIATION varchar(50),
                                            DATE_ASSOCIATION datetime DEFAULT CURRENT_TIMESTAMP,
                                            PRIMARY KEY (ID_DETAILS_TRAJET_ASSOCIE,ID_USER_ASSOCIE),
                                            FOREIGN KEY (ID_DETAILS_TRAJET_ASSOCIE) REFERENCES details_trajet(ID_DETAILS_TRAJET),
                                            FOREIGN KEY (ID_USER_ASSOCIE) REFERENCES users(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
