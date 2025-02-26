# Utilisation de CentOS 8 comme base
FROM centos:8


# Corriger les repos pour CentOS 7
RUN sed -i 's|^mirrorlist=|#mirrorlist=|g' /etc/yum.repos.d/CentOS-* \
    && sed -i 's|^#baseurl=|baseurl=|g' /etc/yum.repos.d/CentOS-* \
    && sed -i 's|mirror.centos.org|vault.centos.org|g' /etc/yum.repos.d/CentOS-*


# Mise à jour du système et installation des dépendances nécessaires
RUN yum update -y && \
    dnf install -y \
    rsyslog ncurses tcpdump && \
    dnf clean all


# Dans le fichier /etc/rsyslog.conf, 
# on décommente les lignes pour permettre les réceptions des logs en UDP et TCP
RUN sed -i -E 's/^#(module\(load="im(udp|tcp)"\))/\1/' /etc/rsyslog.conf &&\
    sed -i -E 's/^#(input\(type="im(udp|tcp)" port="514"\))/\1/' /etc/rsyslog.conf

# Exposer le port 514 pour Syslog
EXPOSE 514

# Ajout script de démarrage de Syslog
COPY start_syslog.sh /start_syslog.sh
RUN chmod +x /start_syslog.sh

# Démarrer Syslog
CMD ["/start_syslog.sh"]



    