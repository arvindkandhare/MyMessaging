package org.arvindkandhare.messaging.client.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by kandha on 9/25/16.
 */
public class MessagingConsumer<K,V> implements Consumer<K, V> {
    public Set<TopicPartition> assignment() {
        return null;
    }

    public Set<String> subscription() {
        return null;
    }

    public void subscribe(List<String> topics) {

    }

    public void subscribe(List<String> topics, ConsumerRebalanceListener callback) {

    }

    public void assign(List<TopicPartition> partitions) {

    }

    public void subscribe(Pattern pattern, ConsumerRebalanceListener callback) {

    }

    public void unsubscribe() {

    }

    public ConsumerRecords<K, V> poll(long timeout) {
        return null;
    }

    public void commitSync() {

    }

    public void commitSync(Map<TopicPartition, OffsetAndMetadata> offsets) {

    }

    public void commitAsync() {

    }

    public void commitAsync(OffsetCommitCallback callback) {

    }

    public void commitAsync(Map<TopicPartition, OffsetAndMetadata> offsets, OffsetCommitCallback callback) {

    }

    public void seek(TopicPartition partition, long offset) {

    }

    public void seekToBeginning(TopicPartition... partitions) {

    }

    public void seekToEnd(TopicPartition... partitions) {

    }

    public long position(TopicPartition partition) {
        return 0;
    }

    public OffsetAndMetadata committed(TopicPartition partition) {
        return null;
    }

    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    public List<PartitionInfo> partitionsFor(String topic) {
        return null;
    }

    public Map<String, List<PartitionInfo>> listTopics() {
        return null;
    }

    public void pause(TopicPartition... partitions) {

    }

    public void resume(TopicPartition... partitions) {

    }

    public void close() {

    }

    public void wakeup() {

    }
}
