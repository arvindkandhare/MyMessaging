package org.arvindkandhare.messaging.client.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by kandha on 9/25/16.
 */
public class MessagingProducer<K,V> implements Producer<K, V> {
    public Future<RecordMetadata> send(ProducerRecord<K, V> record) {
        return null;
    }

    public Future<RecordMetadata> send(ProducerRecord<K, V> record, Callback callback) {
        return null;
    }

    public void flush() {

    }

    public List<PartitionInfo> partitionsFor(String topic) {
        return null;
    }

    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    public void close() {

    }

    public void close(long timeout, TimeUnit unit) {

    }
}
