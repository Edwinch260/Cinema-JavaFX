-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2023 at 01:51 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `IdAdmin` int(10) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `admin`:
--

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`IdAdmin`, `Username`, `Email`, `Password`) VALUES
(1, 'valen', 'valencia@gmail.com', '12345'),
(2, 'edwin', 'edwin@gmail.com', '12345'),
(3, 'mayumi', 'mayumi@gmail.com', '12345'),
(4, 'asdos', 'asdos@gmail.com', '12345'),
(5, 'asdos2', 'asdos2@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `IdAkun` int(10) NOT NULL,
  `NamaAkun` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `VirtualAccount` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `akun`:
--

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`IdAkun`, `NamaAkun`, `Email`, `VirtualAccount`) VALUES
(1, 'edwin123', 'edwin123@gmail.com', '100001'),
(2, 'valen1717', 'valen1717@gmail.com', '100002'),
(3, 'maytoum99', 'maytoum99@gmail.com', '100003'),
(4, 'tomoko00', 'tomoko00@gmail.com', '100004'),
(5, 'chrishenry111', 'chrishenry@gmail.com', '100005');

-- --------------------------------------------------------

--
-- Table structure for table `akunkota`
--

CREATE TABLE `akunkota` (
  `IdKota` int(10) NOT NULL,
  `IdAkun` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `akunkota`:
--   `IdAkun`
--       `akun` -> `IdAkun`
--

--
-- Dumping data for table `akunkota`
--

INSERT INTO `akunkota` (`IdKota`, `IdAkun`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `IdFilm` int(10) NOT NULL,
  `IdRuangan` int(10) NOT NULL,
  `Tanggal` date NOT NULL DEFAULT current_timestamp(),
  `NamaFilm` varchar(50) NOT NULL,
  `Jam` varchar(10) NOT NULL,
  `BatasUsia` varchar(5) NOT NULL,
  `SInopsis` varchar(100) NOT NULL,
  `CheckBox` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `film`:
--

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`IdFilm`, `IdRuangan`, `Tanggal`, `NamaFilm`, `Jam`, `BatasUsia`, `SInopsis`, `CheckBox`) VALUES
(1, 1, '2023-06-07', 'Guardians of the Galaxy', '11:00', '16+', 'Volume 3', NULL),
(2, 2, '2023-06-08', 'Evil Dead Rise', '13:30', '18+', '', NULL),
(3, 3, '2023-06-09', 'Fast X', '15:05', '18+', '', NULL),
(4, 4, '2023-06-10', 'The Super Mario Bros. Movie', '17:15', 'SU', '', NULL),
(5, 5, '2023-06-11', 'Born to Fly', '20:00', '20+', '', NULL),
(7, 2, '2023-06-11', 'The Little Mermaid', '20:00', '13+', 'Live version', NULL),
(8, 1, '2023-06-11', 'The Little Mermaid', '12:30', '13+', '', NULL),
(10, 1, '2023-06-02', 'SpiderMan', '15:30', '13+', 'into the multiverse', NULL),
(11, 2, '2023-06-12', 'Transformer', '12:30', '13+', 'lala', 'D'),
(12, 1, '2023-06-23', 'Lala', '12:00', '13+', 'lalala', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `filmcopy`
--

CREATE TABLE `filmcopy` (
  `FilmCopyId` int(10) NOT NULL,
  `FilmId` int(10) NOT NULL,
  `NamaFilm` varchar(50) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jam` int(5) NOT NULL,
  `RuanganId` int(10) NOT NULL,
  `BatasUsia` varchar(5) NOT NULL,
  `Sinopsis` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `filmcopy`:
--

-- --------------------------------------------------------

--
-- Table structure for table `jamstudio`
--

CREATE TABLE `jamstudio` (
  `IdRuangan` int(10) NOT NULL,
  `IdJam` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `jamstudio`:
--

--
-- Dumping data for table `jamstudio`
--

INSERT INTO `jamstudio` (`IdRuangan`, `IdJam`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `jamtayang`
--

CREATE TABLE `jamtayang` (
  `IdJam` int(10) NOT NULL,
  `Jam` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `jamtayang`:
--

--
-- Dumping data for table `jamtayang`
--

INSERT INTO `jamtayang` (`IdJam`, `Jam`) VALUES
(1, '11:00'),
(2, '12:30'),
(3, '15:05'),
(4, '16:40'),
(5, '19:05');

-- --------------------------------------------------------

--
-- Table structure for table `kotafilm`
--

CREATE TABLE `kotafilm` (
  `IdKota` int(10) NOT NULL,
  `IdFilm` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `kotafilm`:
--

--
-- Dumping data for table `kotafilm`
--

INSERT INTO `kotafilm` (`IdKota`, `IdFilm`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `IdRuangan` int(10) NOT NULL,
  `NamaRuangan` varchar(10) NOT NULL,
  `Lantai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `studio`:
--

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`IdRuangan`, `NamaRuangan`, `Lantai`) VALUES
(1, 'Studio 1', 1),
(2, 'Studio 2', 1),
(3, 'Studio 3', 1),
(4, 'Studio 4', 1),
(5, 'Studio 5', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tanggalcinema`
--

CREATE TABLE `tanggalcinema` (
  `IdTanggal` int(10) NOT NULL,
  `IdCinema` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `tanggalcinema`:
--

--
-- Dumping data for table `tanggalcinema`
--

INSERT INTO `tanggalcinema` (`IdTanggal`, `IdCinema`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tanggalfilm`
--

CREATE TABLE `tanggalfilm` (
  `IdTanggal` int(10) NOT NULL,
  `IdFilm` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `tanggalfilm`:
--

--
-- Dumping data for table `tanggalfilm`
--

INSERT INTO `tanggalfilm` (`IdTanggal`, `IdFilm`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tanggaltayang`
--

CREATE TABLE `tanggaltayang` (
  `IdTanggal` int(10) NOT NULL,
  `Tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `tanggaltayang`:
--

--
-- Dumping data for table `tanggaltayang`
--

INSERT INTO `tanggaltayang` (`IdTanggal`, `Tanggal`) VALUES
(1, '2023-06-07'),
(2, '2023-06-08'),
(3, '2023-06-09'),
(4, '2023-06-10'),
(5, '2023-06-11');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `IdTransaksi` int(10) NOT NULL,
  `IdAkun` int(10) NOT NULL,
  `IdFilm` int(10) NOT NULL,
  `IdRuangan` int(10) NOT NULL,
  `TanggalTransaksi` date NOT NULL,
  `JumlahTiket` int(5) NOT NULL,
  `JumlahTotal` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `transaksi`:
--   `IdAkun`
--       `akun` -> `IdAkun`
--   `IdFilm`
--       `film` -> `IdFilm`
--   `IdRuangan`
--       `studio` -> `IdRuangan`
--

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`IdTransaksi`, `IdAkun`, `IdFilm`, `IdRuangan`, `TanggalTransaksi`, `JumlahTiket`, `JumlahTotal`) VALUES
(1, 1, 1, 1, '2023-05-07', 2, 100000),
(2, 2, 2, 2, '2023-05-08', 3, 150000),
(3, 3, 3, 3, '2023-05-09', 2, 125000),
(4, 4, 4, 4, '2023-06-10', 1, 70000),
(5, 5, 5, 5, '2023-06-10', 1, 80000),
(36, 1, 1, 1, '2023-06-12', 2, 100000),
(37, 2, 7, 2, '2023-06-12', 1, 50000),
(38, 2, 10, 1, '2023-06-12', 1, 100000),
(39, 5, 1, 1, '2023-05-05', 1, 50000),
(41, 3, 7, 2, '2023-05-10', 1, 50000),
(42, 4, 4, 4, '2023-04-12', 2, 100000),
(43, 3, 7, 2, '2023-04-04', 2, 150000),
(44, 1, 10, 1, '2023-04-18', 1, 50000),
(45, 2, 2, 2, '2023-04-20', 1, 50000),
(46, 5, 1, 1, '2023-04-17', 2, 100000),
(47, 1, 1, 1, '2023-06-23', 1, 50000),
(48, 1, 12, 1, '2023-06-23', 2, 100000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`IdAdmin`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`IdAkun`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`IdFilm`);

--
-- Indexes for table `filmcopy`
--
ALTER TABLE `filmcopy`
  ADD PRIMARY KEY (`FilmCopyId`);

--
-- Indexes for table `jamtayang`
--
ALTER TABLE `jamtayang`
  ADD PRIMARY KEY (`IdJam`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`IdRuangan`);

--
-- Indexes for table `tanggaltayang`
--
ALTER TABLE `tanggaltayang`
  ADD PRIMARY KEY (`IdTanggal`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`IdTransaksi`),
  ADD KEY `IdAkun` (`IdAkun`),
  ADD KEY `IdFilm` (`IdFilm`),
  ADD KEY `IdRuangan` (`IdRuangan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `IdAdmin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `IdAkun` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `IdFilm` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `filmcopy`
--
ALTER TABLE `filmcopy`
  MODIFY `FilmCopyId` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jamtayang`
--
ALTER TABLE `jamtayang`
  MODIFY `IdJam` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tanggaltayang`
--
ALTER TABLE `tanggaltayang`
  MODIFY `IdTanggal` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `IdTransaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `akunkota`
--
ALTER TABLE `akunkota`
  ADD CONSTRAINT `akunkota_ibfk_1` FOREIGN KEY (`IdAkun`) REFERENCES `akun` (`IdAkun`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`IdAkun`) REFERENCES `akun` (`IdAkun`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`IdFilm`) REFERENCES `film` (`IdFilm`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`IdRuangan`) REFERENCES `studio` (`IdRuangan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
