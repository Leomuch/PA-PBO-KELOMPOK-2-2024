-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2024 at 04:25 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'admin', 'ADMIN'),
(2, '1', 'uubTVe60y1hFY0ih52fkxg==', 'ADMIN'),
(3, '2', 'Mh4bIcREovTGWxfeX1XICg==', 'ADMIN'),
(4, '3', 'fOPZ/77/c/zAZKOuJJ4LnQ==', 'ADMIN'),
(5, '4', 'z0AFSZ4itJpzpvgjQye6kg==', 'ADMIN'),
(6, '7', 'AiHNmLUAg4L0gMPbMMWM/g==', 'ADMIN'),
(7, '8', 'oW7pKLJyFzmjTyLDJ9HOEA==', 'ADMIN'),
(8, 'a', '3if7SGgDfGaG/bfInY73OA==', 'ADMIN'),
(9, 'anjay', 'orzwiQav7AdeK2BgXGoVcg==', 'ADMIN'),
(10, 'user', 'orzwiQav7AdeK2BgXGoVcg==', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `kontrakpemain`
--

CREATE TABLE `kontrakpemain` (
  `kontrakAwal` date NOT NULL,
  `kontrakAkhir` date NOT NULL,
  `nilaiKontrak` double NOT NULL,
  `klausulPelepasan` double NOT NULL,
  `idPemain` int(11) NOT NULL,
  `namaPemain` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pemain`
--

CREATE TABLE `pemain` (
  `idPemain` int(11) NOT NULL,
  `namaPemain` varchar(255) NOT NULL,
  `asalKlub` varchar(255) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `umur` int(11) NOT NULL,
  `negara` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemain`
--

INSERT INTO `pemain` (`idPemain`, `namaPemain`, `asalKlub`, `tanggalLahir`, `umur`, `negara`) VALUES
(1, 'Kylian Mbappe', 'PSG', '1998-12-20', 25, 'Prancis'),
(2, 'Frenkie De Jong', 'Barcelona', '1997-05-12', 27, 'Belanda'),
(3, 'Lionel Messi', 'Inter Miami', '1987-06-24', 36, 'Argentina'),
(4, 'Jude Bellingham', 'Real Madrid', '2003-06-29', 20, 'Inggris'),
(5, 'Pablo Gavi', 'Barcelona', '2004-08-05', 19, 'Spanyol'),
(6, 'Pedri Gonzales', 'Barcelona', '2002-11-25', 21, 'Spanyol'),
(7, 'Erling Halland', 'Man City', '2000-07-21', 23, 'Norwegia'),
(8, 'Alejandro Garnacho', 'Man United', '2004-07-01', 19, 'Argentina'),
(9, 'Julian Alvarez', 'Man City', '2000-01-31', 24, 'Argentina'),
(10, 'Phil Foden', 'Man City', '2000-05-28', 24, 'Inggris'),
(11, 'Mohammed Salah', 'Liverpool', '1992-06-15', 31, 'Mesir'),
(12, 'Thomas Muller', 'Bayern Munchen', '1989-09-13', 34, 'Jerman'),
(13, 'Gabriel Jesus', 'Arsenal', '1997-04-03', 27, 'Brazil'),
(14, 'Timo Werner', 'Tottenham', '1996-03-06', 28, 'Jerman'),
(15, 'Robert Sanchez', 'Chelsea', '1997-11-18', 26, 'Spanyol'),
(16, 'Enzo Fernandez', 'Chelsea', '2001-01-17', 23, 'Argentina'),
(17, 'Jamal Musiala', 'Bayern Munchen', '2003-02-26', 21, 'Jerman'),
(18, 'Lamine Yamal', 'Barcelona', '2007-07-13', 16, 'Spanyol'),
(19, 'Florian Wirtz', 'Bayer Leverkusen', '2003-05-03', 21, 'Jerman');

-- --------------------------------------------------------

--
-- Table structure for table `statistik`
--

CREATE TABLE `statistik` (
  `idPemain` int(11) NOT NULL,
  `posisi` varchar(255) NOT NULL,
  `gol` int(11) NOT NULL,
  `assist` int(11) NOT NULL,
  `match` int(11) NOT NULL,
  `namaPemain` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `statistik`
--

INSERT INTO `statistik` (`idPemain`, `posisi`, `gol`, `assist`, `match`, `namaPemain`) VALUES
(4, 'Gelandang', 20, 5, 30, 'Jude Bellingham');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pemain`
--
ALTER TABLE `pemain`
  ADD PRIMARY KEY (`idPemain`);

--
-- Indexes for table `statistik`
--
ALTER TABLE `statistik`
  ADD KEY `idPemain` (`idPemain`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pemain`
--
ALTER TABLE `pemain`
  MODIFY `idPemain` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
