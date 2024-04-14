package com.carlosjr.notify.app;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AwsConfig {

    @Value("${aws.access-key}")
    private String accessKey;

    @Value("${aws.secret-key}")
    private String secretKey;

    @Bean
    AWSStaticCredentialsProvider awsCredentials(){
        var credentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AWSStaticCredentialsProvider(credentials);
    }

    @Bean
    AmazonSNS amazonSNS(AWSStaticCredentialsProvider awsCredentials){
        return AmazonSNSClientBuilder
                .standard()
                .withCredentials(awsCredentials)
                .withRegion(Regions.SA_EAST_1)
                .build();
    }

}
