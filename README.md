# 🌱 ỨNG DỤNG TÍNH TOÁN KHÍ THẢI CO₂ VÀ HỆ THỐNG THỬ THÁCH CÁ NHÂN (MAF)

## 🧭 Mô tả hệ thống
Ứng dụng di động được xây dựng bằng **Kotlin** và **Jetpack Compose**, giúp người dùng:
- Theo dõi và **tính toán lượng khí thải CO₂ cá nhân** dựa trên hoạt động sinh hoạt.
- Tham gia **các thử thách xanh (MAF)** để giảm phát thải và cải thiện lối sống.
- Cung cấp **kiến thức bảo vệ môi trường**, hướng đến phát triển bền vững.

---

## ⚙️ Tính năng chính
✅ Nhập thông tin người dùng (tên, nghề nghiệp, tuổi)  
✅ Chọn thời gian và thực hiện khảo sát về sinh hoạt (đi lại, năng lượng, tiêu thụ)  
✅ Tự động tính toán lượng **CO₂ phát thải cá nhân**  
✅ Đưa ra **biện pháp và thử thách xanh** tương ứng với kết quả  
✅ Lưu dữ liệu người dùng bằng API nội bộ (DBHelper)  
✅ Giao diện hiện đại sử dụng **Material 3** và **Navigation Compose**  
✅ Có thể mở rộng để đồng bộ dữ liệu qua Internet

---

## 🧩 Logic tính toán khí thải CO₂
Ứng dụng sử dụng **các hệ số phát thải trung bình** cho từng hoạt động, ví dụ:
- Đi xe máy: ~0.12 kg CO₂/km
- Dùng điện sinh hoạt: ~0.65 kg CO₂/kWh
- Ăn thịt đỏ: ~27 kg CO₂/kg

Công thức tổng quát: Tổng CO₂ = Σ (hoạt động_i × hệ_số_i)


Dữ liệu này được xử lý trong **SurveyScreen.kt** và kết quả hiển thị tại **ResultScreen.kt**, sau đó hiển thị thử thách trong **ChallengeScreen.kt**.

---

## 🏗️ Cấu trúc hệ thống

carbontracker/
├── MainActivity.kt # Điểm khởi đầu ứng dụng
├── navigation/
│ └── AppNavigation.kt # Điều hướng giữa các màn hình
├── data/
│ ├── DBHelper.kt # Kết nối API lưu dữ liệu người dùng
│ ├── UserData.kt # Mô hình dữ liệu người dùng
│ └── UserDataState.kt # Trạng thái toàn cục
├── ui/screens/
│ ├── WelcomeScreen.kt # Màn hình chào
│ ├── UserInfoScreen.kt # Nhập thông tin người dùng
│ ├── DateSelectionScreen.kt # Chọn thời gian
│ ├── SurveyScreen.kt # Khảo sát hoạt động
│ ├── ResultScreen.kt # Kết quả CO₂
│ ├── ChallengeScreen.kt # Thử thách xanh
│ ├── DashboardScreen.kt # Bảng điều khiển
│ └── KnowledgeScreen.kt # Kiến thức môi trường
└── ui/theme/
├── Color.kt
├── Type.kt
└── Theme.kt


---

## 🚀 Cài đặt
### 1. Yêu cầu
- Android Studio Giraffe trở lên
- JDK 17
- Android SDK 33+

### 2. Clone và chạy project
```bash
git clone https://github.com/<username>/CarbonTracker.git
cd CarbonTracker

💾 Database (server-side)

Server lưu dữ liệu người dùng và lịch sử CO₂:
CREATE TABLE user_data (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    age INTEGER,
    occupation TEXT,
    co2_value REAL,
    challenge_level TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
🔄 Quy trình hoạt động

Người dùng nhập thông tin cơ bản.

Chọn tháng/năm cần tính.

Điền khảo sát sinh hoạt.

Ứng dụng tính toán lượng CO₂ phát thải.

Hệ thống gợi ý thử thách giảm phát thải.

Người dùng theo dõi kết quả tại Dashboard.

📊 Ưu điểm

🎨 Giao diện Material 3 hiện đại

📱 Tương thích tốt trên mọi kích thước màn hình

⚡ Xử lý nhanh, không lag

🔄 Có thể mở rộng với API thực tế

🧠 Công nghệ sử dụng

Ngôn ngữ: Kotlin

Framework: Jetpack Compose

Giao diện: Material Design 3

Navigation: Compose Navigation

Database: SQLite / PHP API

Kiến trúc: MVVM (đơn giản hóa)

🔮 Mở rộng trong tương lai

Tích hợp API khí hậu thực tế

Hệ thống xếp hạng thử thách xanh

Biểu đồ CO₂ theo tuần/tháng

Đồng bộ dữ liệu qua Firebase / Cloud

Chế độ cộng đồng chia sẻ thử thách

🧑‍💻 Tác giả

Nhóm sinh viên phát triển trong khuôn khổ môn Lập trình Thiết bị Di động.
Công nghệ sử dụng: Kotlin + Jetpack Compose + Material 3

🪪 Giấy phép

MIT License – sử dụng tự do cho mục đích học tập và nghiên cứu.