#!/bin/bash
set -e  # Arrête le script en cas d'erreur

echo "Démarrage de Syslog ..."
exec rsyslogd -n