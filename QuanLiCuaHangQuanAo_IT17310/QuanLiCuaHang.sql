USE [master]
GO
/****** Object:  Database [DuAn1_QuanLiCuaHang]    Script Date: 12/10/2022 6:36:47 PM ******/
CREATE DATABASE [DuAn1_QuanLiCuaHang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'quanlysieuthimini', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\quanlysieuthimini.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'quanlysieuthimini_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\quanlysieuthimini_log.ldf' , SIZE = 2816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DuAn1_QuanLiCuaHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ARITHABORT OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET RECOVERY FULL 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET  MULTI_USER 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET QUERY_STORE = OFF
GO
USE [DuAn1_QuanLiCuaHang]
GO
/****** Object:  UserDefinedFunction [dbo].[fn_demsohoadon]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fn_demsohoadon]()
	RETURNS int
	AS
	BEGIN
		DECLARE @sohoadon int
		SELECT @sohoadon = COUNT(*) FROM HoaDon
		RETURN @sohoadon
	END
GO
/****** Object:  Table [dbo].[DonViTinh]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonViTinh](
	[MaDVT] [int] IDENTITY(1,1) NOT NULL,
	[MoTa] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_DonViTinh] PRIMARY KEY CLUSTERED 
(
	[MaDVT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [nvarchar](9) NOT NULL,
	[MaKhachHang] [nvarchar](7) NOT NULL,
	[MaNhanVien] [nvarchar](20) NOT NULL,
	[NgayBan] [date] NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[ChietKhau] [decimal](12, 3) NOT NULL,
	[VAT] [decimal](3, 1) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[TienKhachTra] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHDCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [nvarchar](9) NOT NULL,
	[MaSanPham] [nvarchar](7) NOT NULL,
	[DonGia] [decimal](12, 3) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaHDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [nvarchar](7) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[DiemThuong] [int] NOT NULL,
	[DienThoai] [nvarchar](11) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[NVQuanLy] [nvarchar](20) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[TenDangNhap] [nvarchar](20) NOT NULL,
	[MatKhau] [nvarchar](20) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[DienThoai] [nvarchar](11) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[VaiTro] [int] NOT NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nvarchar](7) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[DienThoai] [nvarchar](11) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhomHang]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomHang](
	[MaNhomHang] [nvarchar](5) NOT NULL,
	[TenNhomHang] [nvarchar](20) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhomHang] PRIMARY KEY CLUSTERED 
(
	[MaNhomHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuHuyChiTiet]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuHuyChiTiet](
	[MaPHCT] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuHuy] [nvarchar](9) NOT NULL,
	[MaSanPham] [nvarchar](7) NOT NULL,
	[DVT] [nvarchar](20) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaVon] [decimal](12, 3) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_PhieuHuyChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPHCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuHuyHang]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuHuyHang](
	[MaPhieuHuy] [nvarchar](9) NOT NULL,
	[LoaiPhieuHuy] [bit] NOT NULL,
	[MaNhanVien] [nvarchar](20) NOT NULL,
	[NgayHuy] [date] NOT NULL,
	[SoLuongHuy] [int] NOT NULL,
	[GiaTriHuy] [decimal](12, 3) NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_PhieuHuyHang] PRIMARY KEY CLUSTERED 
(
	[MaPhieuHuy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuKiemChiTiet]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuKiemChiTiet](
	[MaPKCT] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuKiem] [nvarchar](9) NOT NULL,
	[MaSanPham] [nvarchar](7) NOT NULL,
	[DonGia] [decimal](12, 3) NOT NULL,
	[DVT] [nvarchar](20) NOT NULL,
	[TonKho] [int] NOT NULL,
	[ThucTe] [int] NOT NULL,
	[SoLuongLech] [int] NOT NULL,
	[GiaTriLech] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_PhieuKiemChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPKCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuKiemKe]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuKiemKe](
	[MaPhieuKiemKe] [nvarchar](9) NOT NULL,
	[MaNhanVien] [nvarchar](20) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[NgayCanBang] [date] NULL,
	[GiaTriLech] [decimal](12, 3) NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_PhieuKiemKe] PRIMARY KEY CLUSTERED 
(
	[MaPhieuKiemKe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapChiTiet]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapChiTiet](
	[MaPNCT] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuNhap] [nvarchar](9) NOT NULL,
	[MaSanPham] [nvarchar](7) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaNhap] [decimal](12, 3) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[HSDMoiNhat] [date] NULL,
 CONSTRAINT [PK_PhieuNhapChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPNCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapHang]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapHang](
	[MaPhieuNhap] [nvarchar](9) NOT NULL,
	[MaNhanVien] [nvarchar](20) NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[MaNCC] [nvarchar](7) NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[ChietKhau] [decimal](3, 1) NOT NULL,
	[VAT] [decimal](3, 1) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhieuNhapHang] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuTraChiTiet]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuTraChiTiet](
	[MaPTCT] [int] NOT NULL,
	[MaPhieuTra] [nvarchar](9) NOT NULL,
	[MaSanPham] [nvarchar](7) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaTra] [decimal](12, 3) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_PhieuTraChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPTCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuTraHang]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuTraHang](
	[MaPhieuTra] [nvarchar](9) NOT NULL,
	[MaNhanVien] [nvarchar](20) NOT NULL,
	[NgayTra] [date] NOT NULL,
	[MaNCC] [nvarchar](7) NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhieuTraHang] PRIMARY KEY CLUSTERED 
(
	[MaPhieuTra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [nvarchar](7) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[MaVach] [nvarchar](50) NULL,
	[MaNhomHang] [nvarchar](5) NOT NULL,
	[MaNCC] [nvarchar](7) NOT NULL,
	[MaDVT] [int] NOT NULL,
	[TonKho] [int] NOT NULL,
	[DinhMucNhoNhat] [int] NOT NULL,
	[DinhMucLonNhat] [int] NULL,
	[GiaVon] [decimal](12, 3) NOT NULL,
	[GiaBan] [decimal](9, 0) NOT NULL,
	[HSDTruoc] [date] NULL,
	[HSDMoiNhat] [date] NULL,
	[HinhAnh] [nvarchar](30) NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DonViTinh] ON 

INSERT [dbo].[DonViTinh] ([MaDVT], [MoTa]) VALUES (1, N'Cái')
SET IDENTITY_INSERT [dbo].[DonViTinh] OFF
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD1', N'KH12', N'nch', CAST(N'2022-12-04' AS Date), 6, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(6850000.000 AS Decimal(12, 3)), CAST(7000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD10', N'KH6', N'nch', CAST(N'2022-12-12' AS Date), 10, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(4000000.000 AS Decimal(12, 3)), CAST(5000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD11', N'KH2', N'nch', CAST(N'2022-12-12' AS Date), 1, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(400000.000 AS Decimal(12, 3)), CAST(500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD12', N'KH18', N'nch', CAST(N'2022-12-12' AS Date), 1, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(400000.000 AS Decimal(12, 3)), CAST(500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD13', N'KH5', N'nch', CAST(N'2022-12-12' AS Date), 1, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(400000.000 AS Decimal(12, 3)), CAST(5000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD14', N'KH0', N'nch', CAST(N'2022-12-15' AS Date), 3, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(105000.000 AS Decimal(12, 3)), CAST(120000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD15', N'KH1', N'nch', CAST(N'2022-12-10' AS Date), 1, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(110000.000 AS Decimal(12, 3)), CAST(500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD16', N'KH33', N'nch', CAST(N'2022-12-10' AS Date), 1, CAST(30000.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(270000.000 AS Decimal(12, 3)), CAST(500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD2', N'KH6', N'nch', CAST(N'2022-12-04' AS Date), 10, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(1300000.000 AS Decimal(12, 3)), CAST(1500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD3', N'KH5', N'nch', CAST(N'2022-12-04' AS Date), 1, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(265000.000 AS Decimal(12, 3)), CAST(300000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD4', N'KH3', N'nch', CAST(N'2022-12-04' AS Date), 7, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(1560000.000 AS Decimal(12, 3)), CAST(1600000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD5', N'KH1', N'nch', CAST(N'2022-12-04' AS Date), 40, CAST(0.000 AS Decimal(12, 3)), CAST(10.0 AS Decimal(3, 1)), CAST(1760000.000 AS Decimal(12, 3)), CAST(2000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD6', N'KH1', N'nch', CAST(N'2022-12-04' AS Date), 3, CAST(0.000 AS Decimal(12, 3)), CAST(10.0 AS Decimal(3, 1)), CAST(1138500.000 AS Decimal(12, 3)), CAST(1200000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD7', N'KH1', N'nch', CAST(N'2022-12-04' AS Date), 10, CAST(70000.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(1950000.000 AS Decimal(12, 3)), CAST(2000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD8', N'KH1', N'nch', CAST(N'2022-12-07' AS Date), 10, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(4200000.000 AS Decimal(12, 3)), CAST(4500000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayBan], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [TienKhachTra]) VALUES (N'HD9', N'KH2', N'nch', CAST(N'2022-12-12' AS Date), 15, CAST(0.000 AS Decimal(12, 3)), CAST(0.0 AS Decimal(3, 1)), CAST(525000.000 AS Decimal(12, 3)), CAST(550000.000 AS Decimal(12, 3)))
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (9, N'HD1', N'SP2', CAST(400000.000 AS Decimal(12, 3)), 1, CAST(400000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (10, N'HD1', N'SP6', CAST(265000.000 AS Decimal(12, 3)), 1, CAST(265000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (11, N'HD1', N'SP8', CAST(900000.000 AS Decimal(12, 3)), 3, CAST(2700000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (12, N'HD1', N'SP11', CAST(110000.000 AS Decimal(12, 3)), 1, CAST(110000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1009, N'HD2', N'SP7', CAST(130000.000 AS Decimal(12, 3)), 10, CAST(1300000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1010, N'HD3', N'SP6', CAST(265000.000 AS Decimal(12, 3)), 1, CAST(265000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1015, N'HD5', N'SP3', CAST(400000.000 AS Decimal(12, 3)), 40, CAST(16000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1017, N'HD7', N'SP6', CAST(265000.000 AS Decimal(12, 3)), 10, CAST(2650000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1018, N'HD8', N'SP14', CAST(420000.000 AS Decimal(12, 3)), 10, CAST(4200000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1032, N'HD9', N'SP1', CAST(350000.000 AS Decimal(12, 3)), 15, CAST(5250000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1033, N'HD10', N'SP2', CAST(400000.000 AS Decimal(12, 3)), 10, CAST(4000000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1034, N'HD11', N'SP2', CAST(400000.000 AS Decimal(12, 3)), 1, CAST(400000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1035, N'HD12', N'SP2', CAST(400000.000 AS Decimal(12, 3)), 1, CAST(400000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1036, N'HD13', N'SP2', CAST(400000.000 AS Decimal(12, 3)), 1, CAST(400000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1037, N'HD14', N'SP1', CAST(350000.000 AS Decimal(12, 3)), 3, CAST(1050000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1038, N'HD15', N'SP11', CAST(1100000.000 AS Decimal(12, 3)), 1, CAST(1100000.000 AS Decimal(12, 3)))
INSERT [dbo].[HoaDonChiTiet] ([MaHDCT], [MaHoaDon], [MaSanPham], [DonGia], [SoLuong], [ThanhTien]) VALUES (1039, N'HD16', N'SP1', CAST(300000.000 AS Decimal(12, 3)), 1, CAST(300000.000 AS Decimal(12, 3)))
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH0', N'Khách lẻ', 9, N'0', 1, CAST(N'2019-01-01' AS Date), N'admin', N'admin@admin', N'0', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH1', N'Trương Công Kha', 10, N'0378929201', 1, CAST(N'1983-05-15' AS Date), N'phupv', N'congkha83@gmail.com', N'401/54 Cây Trâm, Gò Vấp, HCM
', N'', 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH10', N'Dương Gia Quyền
', 0, N'0965279083', 1, CAST(N'2000-10-12' AS Date), N'khanhnq', N'dgiaquyen40@gmail.com
', N'36/31 Trịnh Đình Thảo, Tân Phú , HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH11', N'Phạm Quốc Thái
', 0, N'0930319076', 1, CAST(N'1989-07-05' AS Date), N'khanhnq', N'phamquocthai0507@gmail.com
', N'21/18 Đông Bắc, Quận 12, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH12', N'Du Diệu Phi', 0, N'0903130195', 0, CAST(N'1997-01-16' AS Date), N'khanhnq', N'phidieu385@gmail.com
', N'57/7 Trần Quý, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH13', N'Vương Thuận Hưng
', 0, N'0769977839', 1, CAST(N'1977-12-17' AS Date), N'phupv', N'thuanhunglol331@gmail.com
', N'331 Minh Phụng, Q11, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH14', N'Nguyễn Tấn Đạt
', 0, N'0933003589', 1, CAST(N'1992-07-10' AS Date), N'thongnn', N'nguyentandat123@gmail.com
', N'115B Lạc Long Quân, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH15', N'Phan Phương Hoàng Châu
', 0, N'0770374798', 0, CAST(N'2000-03-12' AS Date), N'khanhnq', N'chaupph1203@gmail.com
', N'21/13 Lê Văn Quới, Bình Tân, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH16', N'Lưu Trịnh Đình
', 0, N'0637548781', 0, CAST(N'1980-11-02' AS Date), N'thongnn', N'luutrinhdinh@gmail.com
', N'103 Miếu Bình Đông, Bình Tân, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH17', N'Lin Gia Hoàn
', 0, N'0933054892', 0, CAST(N'2000-12-01' AS Date), N'khanhnq', N'lingiahoandl@gmail.com
', N'B25/32 Cây Cám, Bình Chánh, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH18', N'Lê Nguyễn Phương Linh
', 0, N'0122702489', 0, CAST(N'1998-01-04' AS Date), N'khanhnq', N'lenguyenphuonglinh@gmail.com
', N'Lô A Chung Cư Lý Thường Kiệt, Q10, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH19', N'Kiều Thanh Ly', 0, N'0963598466', 0, CAST(N'1988-05-05' AS Date), N'thongnn', N'kieuthanhly@gmail.com
', N'220 Hàn Hải Nguyên, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH2', N'Trương Tuấn Kiệt
', 0, N'0938615883', 1, CAST(N'2000-07-11' AS Date), N'phupv', N'ttkiet72@gmail.com', N'105 Miếu Bình Đông, Bình Tân, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH20', N'Lâm Trung Hiếu
', 0, N'0770445133', 1, CAST(N'1996-12-12' AS Date), N'phupv', N'lamtrunghieu@gmail.com
', N'130 Ông Ích Khiêm, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH21', N'Nguyễn Gia Lương
', 0, N'0933722712', 1, CAST(N'1983-07-09' AS Date), N'phupv', N'nguyengialuong@gmail.com
', N'119/3 đường 3/2, Q10, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH22', N'Nguyễn Thanh Ngân
', 0, N'0673525223', 0, CAST(N'1979-08-04' AS Date), N'phupv', N'nguyenthanhngan@gmail.com
', N'130 Nguyễn Trãi, Q5, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH23', N'Sầm Yến Nhi
', 0, N'0367533632', 0, CAST(N'2000-12-09' AS Date), N'thongnn', N'samyennhi@gmail.com
', N'529 Minh Phụng, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH24', N'Nguyễn Thanh Như 
', 0, N'0777849853', 0, CAST(N'1979-05-06' AS Date), N'thongnn', N'nguyenthanhnhu@gmail.com
', N'278 Hàn Hải Nguyên, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH25', N'Phạm Thái Hồng Nghĩa
', 0, N'0906977495', 1, CAST(N'1989-03-03' AS Date), N'thongnn', N'phamthaihongnghia@gmail.com
', N'44 Hòa Bình , Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH26', N'Nguyễn Thị Trúc Phương
', 0, N'0126433408', 0, CAST(N'1969-06-21' AS Date), N'khanhnq', N'nguyenthitrucphuong@gmail.com
', N'134 Tạ Uyên, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH27', N'Huỳnh Chí Quyền
', 0, N'0776304589', 1, CAST(N'1977-02-02' AS Date), N'khanhnq', N'huynhchiquyen@gmail.com
', N'1106 Võ Văn Kiệt, Q1, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH28', N'Nguyễn Tấn Tài
', 0, N'0377461547', 1, CAST(N'1969-06-10' AS Date), N'thongnn', N'nguyentantai@gmail.com
', N'875 CMT8, Tân Bình, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH29', N'Trần Thiên Tiên
', 0, N'0769635866', 0, CAST(N'1990-08-17' AS Date), N'khanhnq', N'tranthientien@gmail.com
', N'06 Bà Hom, Q6, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH3', N'Lê Nguyễn Thúy Hằng
', 0, N'0818309639', 0, CAST(N'1988-05-15' AS Date), N'thongnn', N'thuyhang16.05@gmail.com
', N'72 Trần Chánh Chiếu, Q5, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH30', N'Võ Minh Tốt
', 0, N'0632210556', 1, CAST(N'1989-10-15' AS Date), N'thongnn', N'vominhtot@gmail.com
', N'197 Hà Tôn Quyền, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH31', N'Từ Mỹ Tuyết
', 0, N'0776435125', 0, CAST(N'1997-11-11' AS Date), N'phupv', N'tumytuyet@gmail.com
', N'231 Cộng Hòa, Tân Bình, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH32', N'Quan Văn Văn
', 0, N'0907763548', 0, CAST(N'2002-09-14' AS Date), N'phupv', N'quanvanvan@gmail.com
', N'105 Lò Siêu, Q11, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH33', N'Cát Tường Vinh
', 3, N'0933641235', 1, CAST(N'1999-01-01' AS Date), N'khanhnq', N'cattuongvinh@gmail.com
', N'190 Phan Xích Long, Phú Nhuận, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH34', N'Nguyễn Tường Vy
', 0, N'0371596633', 0, CAST(N'2000-11-04' AS Date), N'khanhnq', N'nguyentuongvy@gmail.com
', N'789 Trần Hưng Đạo, Q5, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH35', N'Lư Thu Yến
', 0, N'0906130500', 0, CAST(N'1970-11-16' AS Date), N'thongnn', N'luthuyen@gmail.com
', N'60A Tản Đà, Q5, HCM
', NULL, 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH36', N'Lê Anh Thơ', 0, N'0369524291', 0, CAST(N'2000-03-05' AS Date), N'admin', N'tracy2000@hotmail.com', N'1021/34/2 Trường Sa, Quận 3, HCM', N'', 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH4', N'Lý Chung Kiệt', 1, N'0786900681', 1, CAST(N'2001-05-28' AS Date), N'phupv', N'lychungkiet@gmail.com', N'173/23/117 Khuông Việt, Tân Phú, HCM
', N'', 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH5', N'Võ Nguyễn Thúy An', 3, N'0917257091', 0, CAST(N'1997-12-23' AS Date), N'khanhnq', N'thuyanvo352@gmail.com', N'100/3 số 3, Gò Vấp, HCM
', N'', 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH6', N'Bùi Văn Thanh Lân', 0, N'0968224450', 1, CAST(N'1991-02-10' AS Date), N'khanhnq', N'lanbui1510@gmail.com', N'358/5/9 CMT8, Q3, HCM
', N'', 1)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH7', N'Nguyễn Minh Tân
', 0, N'0369512490', 1, CAST(N'1994-02-12' AS Date), N'thongnn', N'tannkox@gmail.com
', N'18 Huỳnh Văn Chính, Tân Phú, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH8', N'Trần Quốc Khánh
', 0, N'0703401012', 1, CAST(N'1991-09-13' AS Date), N'thongnn', N'qkhanh123@gmail.com
', N'304/14 Phạm Thế Hiển, Q8, HCM
', NULL, 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [DiemThuong], [DienThoai], [GioiTinh], [NgaySinh], [NVQuanLy], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'KH9', N'Phạm Thị Thu Trang
', 0, N'0702013985', 0, CAST(N'1979-12-08' AS Date), N'phupv', N'tp2112201717@gmail.com
', N'35 Nguyễn Văn Yến, Tân Phú, HCM
', NULL, 0)
GO
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [HoTen], [DienThoai], [GioiTinh], [NgaySinh], [Email], [DiaChi], [VaiTro], [TrangThai]) VALUES (N'mi', N'123', N'Trà Mi', N'0987654321', 0, CAST(N'2003-12-04' AS Date), N'mi@fpt.com.vn', N'ahahahaa', 2, 0)
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [HoTen], [DienThoai], [GioiTinh], [NgaySinh], [Email], [DiaChi], [VaiTro], [TrangThai]) VALUES (N'nch', N'123', N'Nguyễn Chung Hiếu', N'0372486240', 1, CAST(N'2003-02-16' AS Date), N'chunghieu@gmail.com', N'30 Hà Thị Khiêm, HCM', 1, 1)
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [HoTen], [DienThoai], [GioiTinh], [NgaySinh], [Email], [DiaChi], [VaiTro], [TrangThai]) VALUES (N'thuan', N'thuan', N'Gia Thuận', N'0777027478', 1, CAST(N'2003-01-01' AS Date), N'phanvanphu@gmail.com', N'B25/32 Cây Cám, Bình Chánh, HCM', 0, 1)
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [HoTen], [DienThoai], [GioiTinh], [NgaySinh], [Email], [DiaChi], [VaiTro], [TrangThai]) VALUES (N'tien', N'tien', N'Nguyễn Quốc Tiến', N'0911353526', 1, CAST(N'1999-01-01' AS Date), N'quockhanh@gmail.com', N'21/18 Đông Bắc, Quận 12, HCM', 1, 1)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DienThoai], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'NCC1', N'Công ty Sang Hà', N'02854484448', N'sangha@sangha.vn', N'154 đường Kênh 19/5, Tây Thạnh, Tân Phú, HCM', N'', 1)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DienThoai], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'NCC2', N'Công ty Mai Kim', N'02838298280', N'sales@boniva.com.vn', N'60K Lê Thị Riêng, Phường Bến Thành, Quận 1, HCM', N'', 1)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DienThoai], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'NCC3', N'Công ty Humana', N'02839492529', N'lienhe@humana.com.vn', N'62/36 Trương Công Định, P. 14, Q. Tân Bình, HCM', N'', 1)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DienThoai], [Email], [DiaChi], [GhiChu], [TrangThai]) VALUES (N'NCC4', N'Công ty IWATER', N'02838479806', N'nam@iwater.vn', N'48 Nguyễn Thị Huỳnh, P. 11, Q. Phú Nhuận, HCM', N'', 1)
GO
INSERT [dbo].[NhomHang] ([MaNhomHang], [TenNhomHang], [GhiChu]) VALUES (N'NH1', N'Tổng hợp', N'')
INSERT [dbo].[NhomHang] ([MaNhomHang], [TenNhomHang], [GhiChu]) VALUES (N'NH2', N'Thời Trang', N'Nhóm hàng phục vụ văn phòng, học tập')
GO
SET IDENTITY_INSERT [dbo].[PhieuHuyChiTiet] ON 

INSERT [dbo].[PhieuHuyChiTiet] ([MaPHCT], [MaPhieuHuy], [MaSanPham], [DVT], [SoLuong], [GiaVon], [ThanhTien]) VALUES (2, N'PH2', N'SP2', N'Chiếc', 10, CAST(3000000.000 AS Decimal(12, 3)), CAST(30000000.000 AS Decimal(12, 3)))
SET IDENTITY_INSERT [dbo].[PhieuHuyChiTiet] OFF
GO
INSERT [dbo].[PhieuHuyHang] ([MaPhieuHuy], [LoaiPhieuHuy], [MaNhanVien], [NgayHuy], [SoLuongHuy], [GiaTriHuy], [GhiChu]) VALUES (N'PH1', 0, N'nch', CAST(N'2022-12-15' AS Date), 10, CAST(1550000.000 AS Decimal(12, 3)), N'Sản phẩm bị lỗi')
INSERT [dbo].[PhieuHuyHang] ([MaPhieuHuy], [LoaiPhieuHuy], [MaNhanVien], [NgayHuy], [SoLuongHuy], [GiaTriHuy], [GhiChu]) VALUES (N'PH2', 1, N'nch', CAST(N'2022-12-15' AS Date), 10, CAST(3000000.000 AS Decimal(12, 3)), N'Sản phẩm bị lỗi')
GO
SET IDENTITY_INSERT [dbo].[PhieuKiemChiTiet] ON 

INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (1, N'PK1', N'SP1', CAST(2800.000 AS Decimal(12, 3)), N'Chiếc', 200, 200, 0, CAST(0.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (2, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 100, 0, CAST(0.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (4, N'PK6', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 97, -3, CAST(-9000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (5, N'PK6', N'SP5', CAST(4500.000 AS Decimal(12, 3)), N'Chiếc', 50, 50, 0, CAST(0.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (6, N'PK6', N'SP8', CAST(7200.000 AS Decimal(12, 3)), N'Quyển', 50, 49, -1, CAST(-7200.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (7, N'PK6', N'SP9', CAST(2200.000 AS Decimal(12, 3)), N'Cuộn', 50, 50, 0, CAST(0.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (8, N'PK6', N'SP1', CAST(2800.000 AS Decimal(12, 3)), N'Chiếc', 200, -1, -1, CAST(-1.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (9, N'PK6', N'SP4', CAST(4700.000 AS Decimal(12, 3)), N'Chiếc', 100, -1, -1, CAST(-1.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (14, N'PK7', N'SP1', CAST(2800.000 AS Decimal(12, 3)), N'Chiếc', 200, 189, -11, CAST(-30800.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (15, N'PK8', N'SP6', CAST(22000.000 AS Decimal(12, 3)), N'Cái', 50, 53, 3, CAST(66000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (16, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 97, -3, CAST(-9000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (17, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 102, 2, CAST(6000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (18, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 92, -8, CAST(-24000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (19, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 95, -5, CAST(-15000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (20, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 95, -5, CAST(-15000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (21, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 95, -5, CAST(-15000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (22, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 100, 95, -5, CAST(-15000.000 AS Decimal(12, 3)))
INSERT [dbo].[PhieuKiemChiTiet] ([MaPKCT], [MaPhieuKiem], [MaSanPham], [DonGia], [DVT], [TonKho], [ThucTe], [SoLuongLech], [GiaTriLech]) VALUES (23, N'PK2', N'SP2', CAST(3000.000 AS Decimal(12, 3)), N'Chiếc', 95, 97, 2, CAST(6000.000 AS Decimal(12, 3)))
SET IDENTITY_INSERT [dbo].[PhieuKiemChiTiet] OFF
GO
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK1', N'nch', CAST(N'2022-12-13' AS Date), NULL, CAST(0.000 AS Decimal(12, 3)), N'đang test thử', 0)
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK2', N'nch', CAST(N'2022-12-13' AS Date), CAST(N'2022-12-15' AS Date), CAST(6000.000 AS Decimal(12, 3)), N'test lần 8 - cân bằng', 1)
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK3', N'nch', CAST(N'2022-12-13' AS Date), NULL, CAST(0.000 AS Decimal(12, 3)), N'abc', 2)
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK6', N'nch', CAST(N'2022-12-14' AS Date), NULL, CAST(-16200.000 AS Decimal(12, 3)), N'', 2)
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK7', N'nch', CAST(N'2022-12-14' AS Date), NULL, CAST(-30800.000 AS Decimal(12, 3)), N'abc dfdf', 2)
INSERT [dbo].[PhieuKiemKe] ([MaPhieuKiemKe], [MaNhanVien], [NgayTao], [NgayCanBang], [GiaTriLech], [GhiChu], [TrangThai]) VALUES (N'PK8', N'nch', CAST(N'2022-12-14' AS Date), NULL, CAST(66000.000 AS Decimal(12, 3)), N'thử lần cuối', 0)
GO
SET IDENTITY_INSERT [dbo].[PhieuNhapChiTiet] ON 

INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (1, N'PN1', N'SP1', 200, CAST(280000.000 AS Decimal(12, 3)), CAST(56000000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (2, N'PN1', N'SP2', 100, CAST(300000.000 AS Decimal(12, 3)), CAST(30000000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (4, N'PN1', N'SP3', 100, CAST(330000.000 AS Decimal(12, 3)), CAST(33000000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (5, N'PN1', N'SP4', 100, CAST(470000.000 AS Decimal(12, 3)), CAST(47000000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (6, N'PN1', N'SP5', 50, CAST(450000.000 AS Decimal(12, 3)), CAST(2250000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (7, N'PN1', N'SP6', 50, CAST(220000.000 AS Decimal(12, 3)), CAST(11000000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (8, N'PN1', N'SP7', 50, CAST(100500.000 AS Decimal(12, 3)), CAST(5250000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (9, N'PN1', N'SP8', 50, CAST(720000.000 AS Decimal(12, 3)), CAST(3600000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (10, N'PN1', N'SP9', 50, CAST(220000.000 AS Decimal(12, 3)), CAST(1100000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (11, N'PN1', N'SP10', 50, CAST(178000.000 AS Decimal(12, 3)), CAST(8900000.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (12, N'PN2', N'SP11', 45, CAST(880000.000 AS Decimal(12, 3)), CAST(3960000.000 AS Decimal(12, 3)), CAST(N'2022-05-15' AS Date))
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (13, N'PN2', N'SP12', 45, CAST(980000.000 AS Decimal(12, 3)), CAST(4410000.000 AS Decimal(12, 3)), CAST(N'2022-03-03' AS Date))
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (14, N'PN2', N'SP13', 10, CAST(750000.000 AS Decimal(12, 3)), CAST(7500000.000 AS Decimal(12, 3)), CAST(N'2022-01-22' AS Date))
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (15, N'PN2', N'SP14', 20, CAST(350000.000 AS Decimal(12, 3)), CAST(7000000.000 AS Decimal(12, 3)), CAST(N'2022-02-27' AS Date))
INSERT [dbo].[PhieuNhapChiTiet] ([MaPNCT], [MaPhieuNhap], [MaSanPham], [SoLuong], [GiaNhap], [ThanhTien], [HSDMoiNhat]) VALUES (16, N'PN2', N'SP15', 30, CAST(250000.000 AS Decimal(12, 3)), CAST(7500000.000 AS Decimal(12, 3)), CAST(N'2022-03-30' AS Date))
SET IDENTITY_INSERT [dbo].[PhieuNhapChiTiet] OFF
GO
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN1', N'tien', CAST(N'2022-10-11' AS Date), N'NCC1', 800, CAST(2.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(5249860.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN10', N'tien', CAST(N'2022-10-25' AS Date), N'NCC2', 400, CAST(3.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(8407960.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN11', N'nch', CAST(N'2022-12-16' AS Date), N'NCC1', 40, CAST(0.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(440000.000 AS Decimal(12, 3)), N'')
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN2', N'tien', CAST(N'2022-10-20' AS Date), N'NCC2', 396, CAST(3.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(7356965.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN3', N'tien', CAST(N'2022-10-20' AS Date), N'NCC3', 164, CAST(3.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(8984140.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN4', N'tien', CAST(N'2022-10-21' AS Date), N'NCC4', 312, CAST(2.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(1562669.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN5', N'tien', CAST(N'2022-10-21' AS Date), N'NCC1', 404, CAST(3.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(10098088.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN6', N'tien', CAST(N'2022-10-22' AS Date), N'NCC1', 520, CAST(4.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(17169715.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN7', N'tien', CAST(N'2022-10-23' AS Date), N'NCC2', 354, CAST(5.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(28895295.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN8', N'tien', CAST(N'2022-10-23' AS Date), N'NCC3', 120, CAST(2.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(2664816.000 AS Decimal(12, 3)), NULL)
INSERT [dbo].[PhieuNhapHang] ([MaPhieuNhap], [MaNhanVien], [NgayNhap], [MaNCC], [TongSoLuong], [ChietKhau], [VAT], [ThanhTien], [GhiChu]) VALUES (N'PN9', N'tien', CAST(N'2022-10-24' AS Date), N'NCC3', 194, CAST(3.0 AS Decimal(3, 1)), CAST(10.0 AS Decimal(3, 1)), CAST(9495233.000 AS Decimal(12, 3)), NULL)
GO
INSERT [dbo].[PhieuTraHang] ([MaPhieuTra], [MaNhanVien], [NgayTra], [MaNCC], [TongSoLuong], [ThanhTien], [GhiChu]) VALUES (N'PT1', N'nch', CAST(N'2022-12-09' AS Date), N'NCC7', 300, CAST(12000000.000 AS Decimal(12, 3)), NULL)
GO
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP1', N'ÁO SƠ MI NAM - TOTODAY - A NEW CHANCE', N'', N'NH2', N'NCC1', 1, 185, 20, 200, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-12-15' AS Date), NULL, N'sp1.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP10', N'
SHORTS JEAN NAM - TOTODAY - 11203', NULL, N'NH2', N'NCC1', 1, 50, 10, 50, CAST(300000.000 AS Decimal(12, 3)), CAST(350000 AS Decimal(9, 0)), NULL, NULL, N'sp2.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP11', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC2', 1, 84, 5, 45, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-05-15' AS Date), CAST(N'2022-05-20' AS Date), N'sp3.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP12', N'ÁO KHOÁC W2AKN10201FOSBA', NULL, N'NH1', N'NCC2', 1, 45, 5, 45, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-03-03' AS Date), CAST(N'2022-03-03' AS Date), N'sp4.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP13', N'ÁO SƠ MI NAM - TOTODAY - A NEW CHANCE', NULL, N'NH1', N'NCC2', 1, 10, 2, 10, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-01-22' AS Date), CAST(N'2022-01-22' AS Date), N'sp5.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP14', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC2', 1, 20, 5, 20, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-02-27' AS Date), CAST(N'2022-02-27' AS Date), N'sp6.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP15', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC2', 1, 30, 6, 30, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), CAST(N'2022-03-30' AS Date), CAST(N'2022-03-30' AS Date), N'sp7.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP2', N'
SHORTS JEAN NỮ RÁCH - TOTODAY - 12201', NULL, N'NH1', N'NCC1', 1, 87, 20, 100, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'sp2.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP3', N'ÁO SƠ MI NAM - TOTODAY - A NEW CHANCE', NULL, N'NH1', N'NCC1', 1, 100, 20, 100, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP4', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC1', 1, 100, 20, 100, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP5', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC1', 1, 50, 10, 50, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP6', N'
SHORTS JEAN NỮ RÁCH - TOTODAY - 12201', NULL, N'NH1', N'NCC1', 1, 50, 10, 50, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP7', N'ÁO SƠ MI NAM - TOTODAY - A NEW CHANCE', NULL, N'NH1', N'NCC1', 1, 50, 10, 50, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP8', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH1', N'NCC1', 1, 50, 10, 50, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaVach], [MaNhomHang], [MaNCC], [MaDVT], [TonKho], [DinhMucNhoNhat], [DinhMucLonNhat], [GiaVon], [GiaBan], [HSDTruoc], [HSDMoiNhat], [HinhAnh], [TrangThai]) VALUES (N'SP9', N'ÁO KHOÁC NỈ UNISEX - TOTODAY - BIG U', NULL, N'NH2', N'NCC1', 1, 50, 10, 50, CAST(280000.000 AS Decimal(12, 3)), CAST(300000 AS Decimal(9, 0)), NULL, NULL, N'spn.jpg', 1)
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NguoiDung] ADD  CONSTRAINT [DF_NguoiDung_VaiTro]  DEFAULT ((0)) FOR [VaiTro]
GO
ALTER TABLE [dbo].[NguoiDung] ADD  CONSTRAINT [DF_NguoiDung_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NhaCungCap] ADD  CONSTRAINT [DF_NhaCungCap_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NguoiDung]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuHuyChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuHuyChiTiet_PhieuHuyHang] FOREIGN KEY([MaPhieuHuy])
REFERENCES [dbo].[PhieuHuyHang] ([MaPhieuHuy])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuHuyChiTiet] CHECK CONSTRAINT [FK_PhieuHuyChiTiet_PhieuHuyHang]
GO
ALTER TABLE [dbo].[PhieuHuyChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuHuyChiTiet_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuHuyChiTiet] CHECK CONSTRAINT [FK_PhieuHuyChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuHuyHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuHuyHang_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuHuyHang] CHECK CONSTRAINT [FK_PhieuHuyHang_NguoiDung]
GO
ALTER TABLE [dbo].[PhieuKiemChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuKiemChiTiet_PhieuKiemKe] FOREIGN KEY([MaPhieuKiem])
REFERENCES [dbo].[PhieuKiemKe] ([MaPhieuKiemKe])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuKiemChiTiet] CHECK CONSTRAINT [FK_PhieuKiemChiTiet_PhieuKiemKe]
GO
ALTER TABLE [dbo].[PhieuKiemChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuKiemChiTiet_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuKiemChiTiet] CHECK CONSTRAINT [FK_PhieuKiemChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuKiemKe]  WITH CHECK ADD  CONSTRAINT [FK_PhieuKiemKe_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuKiemKe] CHECK CONSTRAINT [FK_PhieuKiemKe_NguoiDung]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhapHang] FOREIGN KEY([MaPhieuNhap])
REFERENCES [dbo].[PhieuNhapHang] ([MaPhieuNhap])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhapHang]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuNhapHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapHang_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuNhapHang] CHECK CONSTRAINT [FK_PhieuNhapHang_NguoiDung]
GO
ALTER TABLE [dbo].[PhieuTraChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuTraChiTiet_PhieuTraHang] FOREIGN KEY([MaPhieuTra])
REFERENCES [dbo].[PhieuTraHang] ([MaPhieuTra])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuTraChiTiet] CHECK CONSTRAINT [FK_PhieuTraChiTiet_PhieuTraHang]
GO
ALTER TABLE [dbo].[PhieuTraChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuTraChiTiet_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuTraChiTiet] CHECK CONSTRAINT [FK_PhieuTraChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuTraHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuTraHang_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuTraHang] CHECK CONSTRAINT [FK_PhieuTraHang_NguoiDung]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DonViTinh] FOREIGN KEY([MaDVT])
REFERENCES [dbo].[DonViTinh] ([MaDVT])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DonViTinh]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhomHang] FOREIGN KEY([MaNhomHang])
REFERENCES [dbo].[NhomHang] ([MaNhomHang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhomHang]
GO
/****** Object:  StoredProcedure [dbo].[sp_insert_hoadon]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_insert_hoadon]
	@MaKhachHang	nvarchar(7) = null,
	@MaNhanVien		nvarchar(20) = null,
	@NgayBan		date = null,
	@TongSoLuong	int = null,
	@ChietKhau		decimal(12,3) = null,
	@VAT			decimal(3,1) = null,
	@ThanhTien		decimal(12,3) = null,
	@TienKhachTra	decimal(12,3) = null
	AS
	BEGIN TRY
		BEGIN TRAN
			DECLARE @MaHoaDon nvarchar(9)
			SET @MaHoaDon = 'HD'+CAST((dbo.fn_demsohoadon()+1) AS varchar)
			INSERT INTO HoaDon(MaHoaDon, MaKhachHang, MaNhanVien, NgayBan, TongSoLuong, ChietKhau, VAT, ThanhTien, TienKhachTra)
				VALUES
				(@MaHoaDon, @MaKhachHang, @MaNhanVien, @NgayBan, @TongSoLuong, @ChietKhau, @VAT, @ThanhTien, @TienKhachTra)
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT N'Loi roi nha'
	END CATCH
GO
/****** Object:  StoredProcedure [dbo].[sp_tongketcuoingay]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_tongketcuoingay] (
	@MaNhanVien nvarchar(20),
	@NgayBan	nvarchar(10)
	)
	AS BEGIN
		SELECT NH.TenNhomHang AS 'TenNhomHang', SUM(['Bang2'].TongSL) AS 'TongSL', SUM(['Bang2'].TongTT) AS 'TongTT'
		FROM 
			(SELECT ['Bang1'].MaSP AS 'MaSP', SP.MaNhomHang AS 'MaNH', ['Bang1'].TongSL AS 'TongSL', ['Bang1'].TongTT AS 'TongTT'
				FROM 
					(SELECT HDCT.MaSanPham AS 'MaSP', SUM(HDCT.SoLuong) AS 'TongSL', SUM(HDCT.ThanhTien) AS 'TongTT'
						FROM HoaDonChiTiet HDCT LEFT JOIN HoaDon HD ON HDCT.MaHoaDon = HD.MaHoaDon
						WHERE HD.MaNhanVien = @MaNhanVien AND HD.NgayBan = @NgayBan
						GROUP BY HDCT.MaSanPham) AS ['Bang1']
					JOIN SanPham SP ON SP.MaSanPham = ['Bang1'].MaSP) AS ['Bang2']
			JOIN NhomHang NH ON NH.MaNhomHang = ['Bang2'].MaNH
		GROUP BY NH.TenNhomHang
	END
GO
/****** Object:  StoredProcedure [dbo].[sp_update_phieukiemke]    Script Date: 12/10/2022 6:36:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_update_phieukiemke] (
	@GiaTriLech decimal(12,3),
	@GhiChu nvarchar(50),
	@TrangThai int,
	@MaPhieuKiem nvarchar(9)
	)
	AS BEGIN
		-- nếu trạng thái cập nhật mới là TẠM thì không cập nhật ngày cân bằng
		IF (@TrangThai = 0) 
			BEGIN
				UPDATE PhieuKiemKe SET GiaTriLech = @GiaTriLech, 
						GhiChu = @GhiChu, TrangThai = @TrangThai
					WHERE MaPhieuKiemKe = @MaPhieuKiem
			END
		-- nếu trạng thái cập nhật mới là CÂN BẰNG thì cập nhật ngày cân bằng
		IF (@TrangThai = 1)
			BEGIN
				DECLARE @NgayCanBang date
				SET @NgayCanBang = (SELECT FORMAT(getdate(), 'yyyy-MM-dd'))
				UPDATE PhieuKiemKe SET GiaTriLech = @GiaTriLech, GhiChu = @GhiChu, TrangThai = @TrangThai,
						NgayCanBang = @NgayCanBang
					WHERE MaPhieuKiemKe = @MaPhieuKiem
			END
	END
GO
USE [master]
GO
ALTER DATABASE [DuAn1_QuanLiCuaHang] SET  READ_WRITE 
GO
