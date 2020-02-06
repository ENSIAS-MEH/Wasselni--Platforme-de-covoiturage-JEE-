-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 06 fév. 2020 à 21:35
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
create database wasselnidb;
use wasselnidb;
--
-- Base de données :  `wasselnidb`
--

-- --------------------------------------------------------

--
-- Structure de la table `details_trajet`
--

CREATE TABLE `details_trajet` (
  `ID_DETAILS_TRAJET` bigint(20) NOT NULL,
  `DATETIME_DEPART` datetime DEFAULT NULL,
  `PRIX_PLACE` int(11) DEFAULT NULL,
  `TYPE_VOITURE` varchar(50) DEFAULT NULL,
  `MODELE_VOITURE` varchar(50) DEFAULT NULL,
  `MARQUE_VOITURE` varchar(50) DEFAULT NULL,
  `CLIMATISATION_VOITURE` int(11) DEFAULT NULL,
  `EFFECTIF` int(11) DEFAULT NULL,
  `ID_TRAJET_CHOISIE` bigint(20) DEFAULT NULL,
  `bagage` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `estassocie_a`
--

CREATE TABLE `estassocie_a` (
  `ID_DETAILS_TRAJET_ASSOCIE` bigint(20) NOT NULL,
  `ID_USER_ASSOCIE` bigint(20) NOT NULL,
  `TYPE_ASSOCIATION` varchar(50) DEFAULT NULL,
  `DATE_ASSOCIATION` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `questions`
--

CREATE TABLE `questions` (
  `id_question` bigint(20) NOT NULL,
  `text_question` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `questions`
--

INSERT INTO `questions` (`id_question`, `text_question`) VALUES
(1, 'Quel était le numéro de la maison et le nom de la rue dans lequel vous viviez enfant?'),
(2, 'Quels étaient les quatre derniers chiffres de votre numéro de téléphone d\'enfance?'),
(3, 'Quel est le prénom de votre enfant aîné??'),
(4, 'What time of the day were you born? (hh:mm)');

-- --------------------------------------------------------

--
-- Structure de la table `trajet`
--

CREATE TABLE `trajet` (
  `ID_TRAJET` bigint(20) NOT NULL,
  `VILLE_DEPART` varchar(100) DEFAULT NULL,
  `QUARTIER_DEPART` varchar(100) DEFAULT NULL,
  `RUE_DEPART` varchar(100) DEFAULT NULL,
  `VILLE_DESTINATION` varchar(100) DEFAULT NULL,
  `QUARTIER_DESTINATION` varchar(100) DEFAULT NULL,
  `RUE_DESTINATION` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `ID` bigint(20) NOT NULL,
  `NOM` varchar(50) DEFAULT NULL,
  `PRENOM` varchar(50) DEFAULT NULL,
  `SEXE` varchar(5) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `REGION` varchar(50) DEFAULT NULL,
  `LOGIN` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `IMAGE_PATH` varchar(200) DEFAULT NULL,
  `DATE_INSCRIPTION` datetime DEFAULT current_timestamp(),
  `RANK` float DEFAULT 5,
  `ACTIVATION` int(11) DEFAULT 1,
  `ID_QUESTION_USER` bigint(20) DEFAULT NULL,
  `reponse` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `details_trajet`
--
ALTER TABLE `details_trajet`
  ADD PRIMARY KEY (`ID_DETAILS_TRAJET`),
  ADD KEY `ID_TRAJET_CHOISIE` (`ID_TRAJET_CHOISIE`);

--
-- Index pour la table `estassocie_a`
--
ALTER TABLE `estassocie_a`
  ADD PRIMARY KEY (`ID_DETAILS_TRAJET_ASSOCIE`,`ID_USER_ASSOCIE`),
  ADD KEY `ID_USER_ASSOCIE` (`ID_USER_ASSOCIE`);

--
-- Index pour la table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id_question`);

--
-- Index pour la table `trajet`
--
ALTER TABLE `trajet`
  ADD PRIMARY KEY (`ID_TRAJET`),
  ADD UNIQUE KEY `TRAJET_UNIQUE` (`VILLE_DEPART`,`QUARTIER_DEPART`,`RUE_DEPART`,`VILLE_DESTINATION`,`QUARTIER_DESTINATION`,`RUE_DESTINATION`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`),
  ADD UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  ADD KEY `ID_QUESTION_USER` (`ID_QUESTION_USER`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `details_trajet`
--
ALTER TABLE `details_trajet`
  MODIFY `ID_DETAILS_TRAJET` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `trajet`
--
ALTER TABLE `trajet`
  MODIFY `ID_TRAJET` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `details_trajet`
--
ALTER TABLE `details_trajet`
  ADD CONSTRAINT `details_trajet_ibfk_1` FOREIGN KEY (`ID_TRAJET_CHOISIE`) REFERENCES `trajet` (`ID_TRAJET`);

--
-- Contraintes pour la table `estassocie_a`
--
ALTER TABLE `estassocie_a`
  ADD CONSTRAINT `estassocie_a_ibfk_1` FOREIGN KEY (`ID_DETAILS_TRAJET_ASSOCIE`) REFERENCES `details_trajet` (`ID_DETAILS_TRAJET`),
  ADD CONSTRAINT `estassocie_a_ibfk_2` FOREIGN KEY (`ID_USER_ASSOCIE`) REFERENCES `users` (`ID`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`ID_QUESTION_USER`) REFERENCES `questions` (`id_question`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
