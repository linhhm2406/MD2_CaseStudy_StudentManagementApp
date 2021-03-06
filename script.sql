USE [StudentManagement]
GO
/****** Object:  Table [dbo].[StudentManagement]    Script Date: 4/22/2020 9:11:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentManagement](
	[ID] [int] NOT NULL,
	[First Name] [nvarchar](50) NULL,
	[Last Name] [nvarchar](50) NULL,
	[Gender] [nchar](10) NULL,
	[Grade] [nchar](10) NULL,
	[Date Of Birth] [nchar](10) NULL,
	[Phone Number] [nchar](20) NULL,
 CONSTRAINT [PK_studentManagement] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (1, N'Dương', N'Tiêu', N'Male      ', N'10.0      ', N'24/06/1991', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (2, N'Chu', N'Bá Thông', N'Female    ', N'8.7       ', N'15/07/1579', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (3, N'Đoàn', N'Trí Hưng', N'Female    ', N'7.5       ', N'12/05/1994', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (4, N'Vương', N'Trùng Dương', N'Male      ', N'9.1       ', N'31/12/1992', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (5, N'Hoàng', N'Dung', N'Female    ', N'4.7       ', N'21/10/2019', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (6, N'Quách', N'Tĩnh', N'Male      ', N'5.3       ', N'31/10/2019', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (7, N'Âu Dương', N'Phong', N'Male      ', N'8.7       ', N'31/10/2019', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (8, N'Hoàng', N'Dược Sư', N'Female    ', N'7.6       ', N'20/08/1538', N'0xx.xxx.xxxx        ')
INSERT [dbo].[StudentManagement] ([ID], [First Name], [Last Name], [Gender], [Grade], [Date Of Birth], [Phone Number]) VALUES (9, N'Hồng Thất', N'Công', N'Female    ', N'8.7       ', N'15/07/1579', N'0xx.xxx.xxxx        ')
