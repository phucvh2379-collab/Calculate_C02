package com.example.carbontracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carbontracker.data.CarbonCalculator
import com.example.carbontracker.data.UserData
import com.example.carbontracker.data.UserDataState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurveyScreen(onCalculateClick: () -> Unit) {
    val scrollState = rememberScrollState()
    val transportModes = listOf(
        "Ô tô",
        "Xe máy",
        "Xe buýt",
        "Ô tô điện",
        "Xe đạp",
        "Đi bộ",
        "Xe tải",
        "Máy bay"
    )
    var selectedModes by remember { mutableStateOf(setOf<String>()) }
    var modeData by remember { mutableStateOf(mapOf<String, Pair<String, String>>()) } // mode -> (km, days)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp)
    ) {
        Text(
            text = "Khảo sát hành vi hàng ngày",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))