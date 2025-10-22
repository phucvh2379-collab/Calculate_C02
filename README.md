
# 🌱 ĐỀ TÀI: Ứng dụng Tính toán khí thải CO₂ và Hệ thống Thử thách Cá nhân

## 1. Lý do chọn đề tài

Biến đổi khí hậu và ô nhiễm môi trường đang là những vấn đề toàn cầu cấp bách. Trong đó, lượng khí thải CO₂ từ hoạt động cá nhân hằng ngày như đi lại, ăn uống, sử dụng điện... góp phần không nhỏ vào tổng lượng phát thải nhà kính. Tuy nhiên, phần lớn người dân chưa ý thức rõ được lượng phát thải CO₂ cá nhân mà mình tạo ra. Vì vậy, ứng dụng tính toán khí thải CO₂ và hệ thống thử thách cá nhân sẽ giúp người dùng:

- Hiểu rõ hơn về tác động môi trường từ các thói quen hằng ngày.
- Có động lực thay đổi hành vi theo hướng bền vững hơn thông qua thử thách và gợi ý cải thiện.
- Góp phần vào mục tiêu phát triển bền vững và bảo vệ môi trường.

## 2. Ý tưởng

Xây dựng một ứng dụng di động cho phép người dùng nhập vào các hoạt động hằng ngày như phương tiện di chuyển, loại thức ăn tiêu thụ, lượng điện tiêu thụ, v.v... Hệ thống sẽ:

- Tính toán lượng CO₂ phát thải tương ứng.
- Đưa ra thống kê, biểu đồ trực quan.
- Đề xuất các thử thách giảm phát thải như: đi xe đạp thay vì đi xe máy, ăn chay 1 ngày/tuần, tắt điện khi không sử dụng,...
- Ghi nhận kết quả thử thách, tạo động lực bằng hệ thống điểm số hoặc huy hiệu.

## 3. Nghiên cứu và phân tích

### 3.1. Nhu cầu người dùng

- Người dùng ngày càng quan tâm đến vấn đề môi trường, nhưng thiếu công cụ cụ thể để đo lường ảnh hưởng của bản thân.
- Cần một công cụ đơn giản, dễ dùng, trực quan để theo dõi lượng khí thải cá nhân và hướng dẫn cải thiện.
- Mong muốn có thêm yếu tố "game hóa" để tạo động lực hành động, thay vì chỉ xem dữ liệu khô khan.

### 3.2. Đối tượng sử dụng

- Học sinh, sinh viên quan tâm đến môi trường và đang học các môn liên quan.
- Người đi làm có ý thức bảo vệ môi trường và muốn theo dõi hoạt động hằng ngày.
- Các tổ chức, trường học có thể sử dụng để triển khai chiến dịch giảm phát thải nội bộ.

### 3.3. Tính năng của đề tài

- **Tính toán khí thải CO₂** dựa trên đầu vào người dùng: phương tiện, thức ăn, điện, nước,...
- **Thống kê và biểu đồ trực quan**: hiển thị tổng lượng CO₂ theo ngày/tuần/tháng.
- **Thử thách cá nhân**: người dùng tham gia thử thách để giảm phát thải.
- **Theo dõi tiến độ**: lưu lại kết quả thử thách, bảng xếp hạng, hệ thống điểm thưởng/huy hiệu.
- **Đề xuất cải thiện**: gợi ý các hành động thay thế có lợi cho môi trường.
- **Đăng nhập và lưu dữ liệu người dùng** để cá nhân hóa trải nghiệm.


## 4. Mô tả hệ thống
Hệ thống web sử dụng **AI** và dữ liệu hành trình để **tự động tính toán lượng khí thải CO₂** phát sinh từ phương tiện cá nhân.  
Đồng thời cung cấp **hệ thống thử thách cá nhân** giúp người dùng giảm phát thải và nâng cao ý thức bảo vệ môi trường.

---

## 5. Tính năng chính
- ✅ **Upload dữ liệu hành trình** (.gpx, .csv, .json) hoặc thu thập trực tiếp từ GPS  
- ✅ **Tính toán khí thải CO₂** dựa trên loại phương tiện và quãng đường di chuyển  
- ✅ **State Machine Logic**: Theo dõi trạng thái hành trình (bắt đầu → di chuyển → dừng → kết thúc)  
- ✅ **Smart Emission Detection**: Loại bỏ dữ liệu sai, chỉ tính CO₂ cho hành trình hợp lệ  
- ✅ **Hệ thống thử thách cá nhân**: Đặt mục tiêu giảm CO₂ theo tuần/tháng  
- ✅ **Theo dõi tiến độ thử thách** theo thời gian thực  
- ✅ **Lưu trữ dữ liệu** hành trình và kết quả tính toán trong **SQLite database**  
- ✅ **Tra cứu lịch sử CO₂** và thống kê theo ngày, tuần, tháng  
- ✅ **Giao diện web responsive**, hiển thị biểu đồ và trạng thái trực quan  
- ✅ **Màu sắc phản hồi trực quan**:
  - 🟢 Tiết kiệm
  - 🟡 Trung bình
  - 🔴 Phát thải cao  

---

## 6. Logic Tính toán Thông minh
Hệ thống sử dụng **Máy trạng thái hữu hạn (Finite State Machine)** để theo dõi quá trình di chuyển, đảm bảo chỉ tính toán khí thải trong điều kiện hợp lệ.

### 🧠 Các Trạng thái của Hành Trình:
| Trạng thái | Mô tả |
|-------------|-------|
| 🟢 **NEUTRAL** | Chưa bắt đầu hành trình |
| 🟡 **IN_TRIP** | Đang di chuyển (bắt đầu tính CO₂) |
| 🟠 **IDLE** | Xe dừng tạm thời (tính CO₂ thấp hơn) |
| 🔴 **SUSPICIOUS** | Dữ liệu không hợp lệ hoặc thiếu liên tục |
| ✅ **COMPLETED** | Hành trình kết thúc hợp lệ |

---

## 7. Logic Tính toán
- Theo dõi hành trình: chỉ tính CO₂ trong giai đoạn **IN_TRIP** hoặc **IDLE hợp lệ**  
- Kiểm tra dữ liệu: loại bỏ **quãng đường bất thường** hoặc **GPS sai lệch**  
- Công thức tính:
- Hỗ trợ nhiều loại xe: **xăng, dầu, điện, hybrid**  
- Chống trùng lặp: mỗi hành trình chỉ được ghi nhận **1 lần duy nhất**  

---

## 8. Hệ thống Thử thách Cá nhân
Người dùng có thể tạo và tham gia các thử thách:
- “Giảm 20% CO₂ trong 7 ngày”
- “Không nổ máy chờ quá 5 phút”
- “Tăng số chuyến đi xanh (eco-driving)”

### 9. Theo dõi tiến độ
- Hiển thị phần trăm hoàn thành theo thời gian thực  
- Cập nhật trạng thái bằng màu sắc (Xanh/Vàng/Đỏ)  
- Trao huy hiệu khi hoàn thành thử thách  
- Lưu lại kết quả và thống kê trong cơ sở dữ liệu  

---

## 10. Ưu điểm
- 🎯 **Độ chính xác cao**: Loại bỏ dữ liệu nhiễu hoặc không hợp lệ  
- 🔍 **Logic rõ ràng**: Theo dõi hành trình và phát thải thực tế  
- 📊 **Hiển thị trực quan**: Biểu đồ, màu sắc trạng thái, thống kê rõ ràng  
- ⚡ **Hiệu suất tốt**: Xử lý dữ liệu hành trình **real-time**

---

## 11. Kết quả
Ứng dụng giúp người dùng:
- Hiểu rõ **lượng phát thải cá nhân**
- Khuyến khích **lái xe tiết kiệm nhiên liệu**
- Góp phần **giảm thiểu ô nhiễm môi trường**

---

