package com.example.sensorscollector2.collector.consumer

import com.example.sensorscollector2.collector.DataEvent
import com.example.sensorscollector2.model.TYPE_SENSOR_EVENT
import com.example.sensorscollector2.pdr.heading.IOrientationDetector
import com.example.sensorscollector2.pdr.step.IStepDetector
import com.example.sensorscollector2.pdr.stride.IStrideStrategy

class NaivePdrConsumer(
    val stepDetector: IStepDetector,
    val orientationDetector: IOrientationDetector,
    val strideLengthStrategy: IStrideStrategy,
    val followingConsumers: List<ISensorEventConsumer>
): ISensorEventConsumer {
    override fun consume(event: DataEvent) {
        when(event.type) {
            TYPE_SENSOR_EVENT -> {

                consumeGeneratedEvent(stepDetector.updateWithDataEvent(event))
                consumeGeneratedEvent(orientationDetector.updateWithDataEvent(event))

                if(stepDetector.isStepDetected()) {
                    // update
                }
            }
        }
    }

    private fun consumeGeneratedEvent(event: DataEvent?) {
        if(event == null) return
        for(consumer in followingConsumers)
            consumer.consume(event)
    }

}