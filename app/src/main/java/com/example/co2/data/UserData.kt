package com.example.carbontracker.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.google.gson.annotations.SerializedName

// State object to hold user input with mutableStateOf for Compose
object UserDataState {
    var name by mutableStateOf("")
    var age by mutableStateOf("")
    var occupation by mutableStateOf("")

    var month by mutableStateOf("")
    var year by mutableStateOf("")
    var daysInMonth by mutableStateOf(30) // Default

    // Transportation: mode -> (km, days)
    var transportOptions by mutableStateOf(mapOf<String, Pair<Double, Int>>())

    // Food
    var isVegetarianFull by mutableStateOf(false)
    var vegetarianDays by mutableStateOf(0)
    var processedFood by mutableStateOf(false)
    var processedFoodDays by mutableStateOf(0)
    var redMeatDays by mutableStateOf(0)

    // Electricity
    var electricityBill by mutableStateOf(0.0)
    var familySize by mutableStateOf(1)
    var totalKWh by mutableStateOf(0.0)

    // Consumption
    var useReusableBagBottle by mutableStateOf(false)
    var phoneHours by mutableStateOf(0.0)
    var laptopHours by mutableStateOf(0.0)
    var gasUsesPerDay by mutableStateOf(0)
    var laundryInterval by mutableStateOf(1) // Every x days

    // Added AC hours
    var acHours by mutableStateOf(0.0) // Hours of air conditioning per day

    var dailyCO2 by mutableStateOf(0.0)
    var monthlyCO2 by mutableStateOf(0.0)
    var co2History by mutableStateOf(listOf<Float>())
    var challengeProgress by mutableStateOf(0)

    // Convert state to API-compatible UserData data class
    fun toUserData(): UserData {
        return UserData(
            name = name,
            age = age.toIntOrNull() ?: 0,
            occupation = occupation,
            month = month.toIntOrNull() ?: 0,
            year = year.toIntOrNull() ?: 0,
            daysInMonth = daysInMonth,
            dailyCO2 = dailyCO2,
            monthlyCO2 = monthlyCO2
        )
    }
}

// Data class for API communication
data class UserData(
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int,
    @SerializedName("occupation") val occupation: String,
    @SerializedName("month") val month: Int,
    @SerializedName("year") val year: Int,
    @SerializedName("daysInMonth") val daysInMonth: Int,
    @SerializedName("dailyCO2") val dailyCO2: Double,
    @SerializedName("monthlyCO2") val monthlyCO2: Double
)

// CarbonCalculator object with calculation functions
object CarbonCalculator {

    /**
     * Calculate daily CO2 based on monthly CO2 and days in month.
     */
    fun calculateDailyCO2(monthlyCO2: Double, daysInMonth: Int): Double {
        return if (daysInMonth > 0) monthlyCO2 / daysInMonth else 0.0
    }

    /**
     * Calculate monthly CO2 based on various inputs.
     */
    fun calculateMonthlyCO2(
        transportOptions: Map<String, Pair<Double, Int>>, // mode -> (km, days)
        isVegetarianFull: Boolean,
        vegetarianDays: Int,
        processedFood: Boolean,
        processedFoodDays: Int,
        redMeatDays: Int,
        totalKWh: Double,
        useReusableBagBottle: Boolean,
        phoneHours: Double,
        laptopHours: Double,
        gasUsesPerDay: Int,
        laundryInterval: Int,
        daysInMonth: Int,
        acHours: Double
    ): Double {
        var totalCO2 = 0.0

        // Transportation emissions
        transportOptions.forEach { (mode, data) ->
            val (km, days) = data
            val emissionFactor = when (mode) {
                "Ô tô" -> 0.171
                "Xe máy" -> 0.114
                "Xe buýt" -> 0.097
                "Ô tô điện" -> 0.047
                "Xe đạp" -> 0.021
                "Đi bộ" -> 0.005
                "Xe tải" -> 0.250
                "Máy bay" -> 0.250
                else -> 0.0
            }
            totalCO2 += km * days * emissionFactor
        }

        // Food emissions
        val foodEmission = if (isVegetarianFull) {
            2.89 * daysInMonth
        } else {
            val normalDays = daysInMonth - vegetarianDays
            (7.19 * normalDays) + (3.81 * vegetarianDays)
        }
        totalCO2 += foodEmission

        if (processedFood) {
            totalCO2 += 1.5 * processedFoodDays
        }
        totalCO2 += redMeatDays * 0.5

        // Electricity emissions
        totalCO2 += totalKWh * 0.6811

        // Consumption
        if (!useReusableBagBottle) {
            totalCO2 += daysInMonth * 0.01810
        }
        totalCO2 += (phoneHours + laptopHours) * daysInMonth * 0.0005

        // Gas stove
        totalCO2 += gasUsesPerDay * daysInMonth * 0.67358

        // Laundry
        val laundryTimes = daysInMonth / laundryInterval
        totalCO2 += laundryTimes * 0.5

        // Air conditioning
        totalCO2 += acHours * daysInMonth * 0.3

        return totalCO2
    }