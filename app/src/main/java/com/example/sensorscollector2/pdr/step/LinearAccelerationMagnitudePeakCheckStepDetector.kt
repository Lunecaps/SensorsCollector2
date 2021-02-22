package com.example.sensorscollector2.pdr.step

import com.example.sensorscollector2.collector.DataEvent

class LinearAccelerationMagnitudePeakCheckStepDetector: IStepDetector {
    override fun updateWithDataEvent(event: DataEvent): DataEvent? {
        return null
    }

    override fun isStepDetected(): Boolean {
        TODO("Not yet implemented")
    }

    override fun lastDetectedTimestamp(): Long {
        TODO("Not yet implemented")
    }
}