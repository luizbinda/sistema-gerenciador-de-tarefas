package com.basis.colatina.gerenciadordetarefas.config.containers;


import org.testcontainers.elasticsearch.ElasticsearchContainer;

public class ContainersFactory {

    private static ContainersFactory containers;

    private static ElasticsearchContainer elastic;

    public static ContainersFactory getInstances() {
        if(elastic == null) {
            elastic = ElasticsearchFactory.getInstance();
        }

        if(containers == null) {
            containers = new ContainersFactory();
        }

        return containers;
    }
}
