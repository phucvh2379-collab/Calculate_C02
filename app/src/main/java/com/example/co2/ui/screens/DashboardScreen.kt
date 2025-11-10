package com.example.carbontracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import com.example.carbontracker.data.UserData
import com.example.carbontracker.data.UserDataState
import kotlin.random.Random

// Hàm xác định màu sắc dựa trên mức độ nghiêm trọng của CO2 (kg) - FIX: Thay Float thành Double để match với dailyCO2
// - Xanh lá: < 3kg (thấp, tốt)
// - Vàng: 3-5kg (trung bình)
// - Đỏ: >5kg (cao, nghiêm trọng)
fun getSeverityColor(co2: Double): Color {  // Đổi từ Float sang Double
    return when {
        co2 < 3.0 -> Color(0xFF4CAF50) // Xanh lá - thấp nhất
        co2 <= 5.0 -> Color(0xFFFF9800) // Vàng - trung bình
        else -> Color(0xFFF44336) // Đỏ - cao
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(onBackClick: () -> Unit) {
    val scrollState = rememberScrollState()

    val weeklyData = remember {
        if (UserDataState.co2History.isEmpty()) {
            List(7) { Random.nextFloat() * 5f + 2f }
        } else {
            UserDataState.co2History.takeLast(7).ifEmpty {
                List(7) { Random.nextFloat() * 5f + 2f }
            }
        }
    }

    val monthlyData = remember {
        List(30) { Random.nextFloat() * 6f + 1f }
    }