# 🌱 ỨNG DỤNG TÍNH TOÁN KHÍ THẢI CO₂ VÀ HỆ THỐNG THỬ THÁCH CÁ NHÂN

---

## 📖 1. Lý do chọn đề tài

Hiện nay, biến đổi khí hậu và ô nhiễm môi trường đang là vấn đề cấp bách toàn cầu. Trong đó, lượng **khí thải CO₂** phát sinh từ các hoạt động hàng ngày như di chuyển, ăn uống, sử dụng điện, tiêu dùng… là nguyên nhân chính gây **hiệu ứng nhà kính**.

Tuy nhiên, đa số người dân chưa ý thức rõ về **mức phát thải cá nhân** cũng như **cách giảm thiểu**.

Ứng dụng **Tính toán khí thải CO₂ và Hệ thống thử thách cá nhân** được phát triển nhằm giúp người dùng:

- Nhận biết lượng CO₂ mình phát thải hàng ngày.
- Theo dõi và cải thiện thói quen sống xanh.
- Tham gia các thử thách giảm phát thải để nâng cao ý thức bảo vệ môi trường.

Đây là một ứng dụng có tính **giáo dục – xã hội – bền vững**, phù hợp với xu hướng **chuyển đổi xanh** và **phát triển bền vững (SDGs)** hiện nay.

---

## 💡 2. Ý tưởng

Ứng dụng hoạt động như một **trợ lý môi trường cá nhân**, giúp người dùng tính toán, theo dõi và giảm lượng khí thải CO₂ từ các hoạt động thường ngày.

**Người dùng có thể:**

- Nhập dữ liệu sinh hoạt: phương tiện di chuyển, lượng điện sử dụng, ăn uống, tiêu dùng…
- Ứng dụng tự động tính toán **lượng CO₂ phát thải** dựa trên hệ số chuẩn.
- Xem **biểu đồ thống kê phát thải** theo ngày, tuần, tháng.
- Tham gia **các thử thách xanh** như “Đi bộ thay vì đi xe máy”, “Ăn chay 1 ngày/tuần”, “Tiết kiệm 1kWh điện mỗi ngày”… để nhận huy hiệu hoặc điểm thưởng.
- Chia sẻ thành tích và lan tỏa thông điệp sống xanh.

---

## 🔍 3. Nghiên cứu và phân tích

### 3.1. Nhu cầu người dùng
- Mong muốn hiểu rõ mức phát thải cá nhân.
- Cần công cụ trực quan, dễ dùng để theo dõi tiến độ sống xanh.
- Có yếu tố **thử thách – động lực – phần thưởng**, giúp duy trì thói quen tốt.

### 3.2. Đối tượng sử dụng
- Học sinh, sinh viên, nhân viên văn phòng và bất kỳ ai quan tâm đến môi trường.
- Người muốn thay đổi thói quen để hướng đến **cuộc sống xanh – bền vững**.

---

## ⚙️ 4. Tính năng chính

### 1️⃣ Tính toán khí thải CO₂
- Người dùng nhập thông tin về:  
  🚗 Phương tiện di chuyển  
  ⚡ Lượng điện tiêu thụ  
  🍽️ Thói quen ăn uống  
  🛍️ Hoạt động tiêu dùng
- Ứng dụng tự động **tính toán lượng CO₂ tương ứng (kg CO₂/ngày)**.

### 2️⃣ Theo dõi và thống kê
- Biểu đồ trực quan hiển thị xu hướng phát thải theo thời gian.
- Cảnh báo khi lượng CO₂ vượt ngưỡng trung bình.

### 3️⃣ Hệ thống thử thách cá nhân
- Danh sách thử thách xanh như:
    - “Đi bộ 3km mỗi ngày”
    - “Ăn chay 2 bữa/tuần”
    - “Tắt điện 30 phút/ngày”
- Mỗi thử thách giúp **giảm lượng CO₂** và người dùng nhận **điểm thưởng xanh**.

### 4️⃣ Xếp hạng & Huy hiệu
- Bảng xếp hạng người dùng tích cực.
- Huy hiệu theo cấp độ: 🌿 Người mới, 🌳 Nhà bảo vệ môi trường, 🌎 Anh hùng xanh.

### 5️⃣ Thống kê cá nhân
- Tổng lượng CO₂ đã giảm được.
- Tỷ lệ hoàn thành thử thách.
- Gợi ý thói quen xanh phù hợp.

### 6️⃣ Cài đặt & Hồ sơ
- Cập nhật thông tin cá nhân.
- Đặt mục tiêu giảm CO₂ hàng tuần/tháng.
- Chuyển đổi đơn vị đo lường (kg – tấn).

---

## 🧩 5. Công nghệ sử dụng

- **Ngôn ngữ:** Kotlin
- **Giao diện:** Jetpack Compose (Material Design 3)
- **Cơ sở dữ liệu:** SQLite (qua Room hoặc SQLiteOpenHelper)
- **Biểu đồ:** MPAndroidChart hoặc Compose Charts
- **Kiến trúc:** MVVM + Navigation Component
- **Tương thích:** Android 8.0 (API 26) trở lên
- **Hình ảnh:** Lưu trong thư mục `drawable/`

---

## 📱 6. Giao diện minh hoạ (dự kiến)

- **Màn hình chào mừng:** Logo và nút “Bắt đầu sống xanh”
- **Màn hình khảo sát:** Nhập dữ liệu hoạt động hàng ngày
- **Màn hình kết quả:** Hiển thị lượng CO₂ phát thải và so sánh trung bình
- **Màn hình thử thách:** Danh sách thử thách xanh có thể tham gia
- **Màn hình thống kê:** Biểu đồ theo thời gian
- **Màn hình hồ sơ:** Huy hiệu, thành tích, mục tiêu

---

## 👥 7. Nhóm thực hiện

- **Tên dự án:** Ứng dụng Tính toán khí thải CO₂ và Hệ thống thử thách cá nhân
- **Thành viên:** Võ Nguyễn Phong Phú, Nguyễn Phạm Thanh Duy, Huỳnh Hồng Thịnh, Lê Văn Giang
- **Giảng viên hướng dẫn:** Trương Quang Tuấn

---

## 🏁 Kết luận

Ứng dụng **Tính toán khí thải CO₂ và Hệ thống thử thách cá nhân** không chỉ giúp người dùng **hiểu rõ tác động môi trường của bản thân**, mà còn **truyền cảm hứng hành động vì hành tinh xanh**.  
Với mục tiêu **“Đo lường – Hành động – Truyền cảm hứng”**, ứng dụng góp phần **nâng cao ý thức cộng đồng** và **hướng tới tương lai bền vững**.
