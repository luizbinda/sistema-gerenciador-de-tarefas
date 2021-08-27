package com.basis.colatina.gerenciadordetarefas.config.containers;

import org.testcontainers.elasticsearch.ElasticsearchContainer;

public class ElasticsearchFactory {

    private static ElasticsearchContainer container;

    public static ElasticsearchContainer getInstance() {
        if(container == null) {
            container = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.6.2");
            container.start();
        }

        return container;
    }
}
