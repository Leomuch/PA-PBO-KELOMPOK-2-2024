-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2024 at 02:58 AM
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
(9, 'anjay', 'orzwiQav7AdeK2BgXGoVcg==', 'ADMIN');

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
  `namaPemain` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kontrakpemain`
--

INSERT INTO `kontrakpemain` (`kontrakAwal`, `kontrakAkhir`, `nilaiKontrak`, `klausulPelepasan`, `idPemain`, `namaPemain`) VALUES
('2023-08-08', '2024-08-08', 450000, 450000, 1, 'Kylian Mbappe');

-- --------------------------------------------------------

--
-- Table structure for table `pemain`
--

CREATE TABLE `pemain` (
  `idPemain` int(11) NOT NULL,
  `namaPemain` varchar(255) NOT NULL,
  `asalKlub` varchar(255) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `umur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemain`
--

INSERT INTO `pemain` (`idPemain`, `namaPemain`, `asalKlub`, `tanggalLahir`, `umur`) VALUES
(1, 'Kylian Mbappe', 'PSG', '1987-12-20', 25),
(2, 'Lionel Messi', 'Inter Miami', '1987-06-24', 36),
(3, 'Frenkie De Jong', 'Barcelona', '1997-05-12', 27);

-- --------------------------------------------------------

--
-- Table structure for table `statistik`
--

CREATE TABLE `statistik` (
  `posisi` varchar(255) NOT NULL,
  `gol` int(11) NOT NULL,
  `assist` int(11) NOT NULL,
  `match` int(11) NOT NULL,
  `idPemain` int(11) NOT NULL,
  `namaPemain` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `statistik`
--

INSERT INTO `statistik` (`posisi`, `gol`, `assist`, `match`, `idPemain`, `namaPemain`) VALUES
('Striker', 20, 25, 20, 1, 'Kylian Mbappe'),
('Striker', 35, 30, 25, 2, 'Lionel Messi'),
('Gelandang', 5, 9, 25, 3, 'Frenkie De Jong');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kontrakpemain`
--
ALTER TABLE `kontrakpemain`
  ADD UNIQUE KEY `idPemain` (`idPemain`);

--
-- Indexes for table `pemain`
--
ALTER TABLE `pemain`
  ADD PRIMARY KEY (`idPemain`);

--
-- Indexes for table `statistik`
--
ALTER TABLE `statistik`
  ADD UNIQUE KEY `idPemain` (`idPemain`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pemain`
--
ALTER TABLE `pemain`
  MODIFY `idPemain` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
