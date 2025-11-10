package com.example.carbontracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carbontracker.data.UserDataState // Import đúng

data class Challenge(
    val day: Int,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val co2Reduction: String,
    var completed: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeScreen(onBackClick: () -> Unit) {
    val challenges = remember {
        mutableStateListOf(
            Challenge(1, "Đi bộ thay vì xe máy", "Đi bộ hoặc đi xe đạp ít nhất 1 chuyến hôm nay", Icons.Default.DirectionsWalk, "0.5 kg CO₂"),
            Challenge(2, "Ăn chay 1 bữa", "Thay thế 1 bữa ăn thịt bằng thức ăn chay", Icons.Default.Eco, "0.8 kg CO₂"),
            Challenge(3, "Tắt điện không cần thiết", "Tắt tất cả thiết bị điện khi không sử dụng", Icons.Default.PowerOff, "0.3 kg CO₂"),
            Challenge(4, "Sử dụng túi vải", "Không sử dụng túi nilon khi mua sắm", Icons.Default.ShoppingBag, "0.2 kg CO₂"),
            Challenge(5, "Tiết kiệm nước", "Giảm thời gian tắm và tắt vòi khi không dùng", Icons.Default.Water, "0.4 kg CO₂"),
            Challenge(6, "Phân loại rác", "Phân loại rác thải đúng cách", Icons.Default.Recycling, "0.3 kg CO₂"),
            Challenge(7, "Chia sẻ kiến thức", "Chia sẻ thông tin về bảo vệ môi trường cho bạn bè", Icons.Default.Share, "Tác động lan tỏa")
        )
    }