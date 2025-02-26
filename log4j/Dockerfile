# Utilisation de CentOS 8 comme base
FROM centos:8


# Corriger les repos pour CentOS 7
RUN sed -i 's|^mirrorlist=|#mirrorlist=|g' /etc/yum.repos.d/CentOS-* \
    && sed -i 's|^#baseurl=|baseurl=|g' /etc/yum.repos.d/CentOS-* \
    && sed -i 's|mirror.centos.org|vault.centos.org|g' /etc/yum.repos.d/CentOS-*


# Mise à jour du système et installation des dépendances nécessaires
RUN yum update -y && \
    yum groupinstall -y "Development Tools" && \
    yum install -y \
    wget cronie tar gcc nano net-tools make perl python2 libacl-devel libblkid-devel gnutls-devel \
    readline-devel glib2-devel libattr-devel keyutils-libs-devel \
    libsepol-devel libuuid-devel libaio-devel cups-devel pam-devel \
    krb5-workstation openldap-devel popt-devel libxml2-devel \
    curl unzip tcpdump \
    python2 python2-pip python2-devel && \
    ln -sf /usr/bin/python2 /usr/bin/python && \
    yum clean all


# Installation de Java:
RUN yum install java-1.8.0-openjdk-devel -y

# Ajout fichier de configuration de Apache Log4j, et ajout logger
RUN mkdir log4j
COPY bin ./log4j/bin/
COPY src ./log4j/src/


# Télécharger Apache Log4j version 2.13.0
RUN curl -L -o log4j.zip https://archive.apache.org/dist/logging/log4j/2.13.0/apache-log4j-2.13.0-bin.zip && \
    unzip log4j.zip && \
    mv apache-log4j-2.13.0-bin ./log4j/lib && \           
    rm log4j.zip &&\
    rm ./log4j/lib/log4j-slf4j18-impl-2.13.0*.jar &&\
    rm ./log4j/lib/log4j-to-slf4j-2.13.0*.jar &&\
    curl -O https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/slf4j-api-1.7.32.jar && \  
    curl -O https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.13.0/jackson-core-2.13.0.jar && \  
    curl -O https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.13.0/jackson-databind-2.13.0.jar && \
    mv slf4j-api-1.7.32.jar ./log4j/lib &&\
    mv jackson-core-2.13.0.jar ./log4j/lib &&\
    mv jackson-databind-2.13.0.jar ./log4j/lib
    

# Exposer le port 4560 pour SocketAppender
EXPOSE 4560

# Ajout script de démarrage de Log4j
COPY start_log4j.sh ./log4j/start_log4j.sh
RUN chmod +x ./log4j/start_log4j.sh

# Démarrer Log4j
CMD ["/log4j/start_log4j.sh"]
