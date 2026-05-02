#!/bin/bash

# Example script similar to:
# https://gitlab.hof-university.de/eganscha/cloud_computing_2025/-/blob/main/services/db/backup_script.sh?ref_type=heads
# (Just use docker compose down -v if you actually want to get rid of the volume)

ENV_FILE=".env"

if [ ! -f "$ENV_FILE" ]; then
  echo "reset_db_volume.sh could not find \$ENV_FILE at $ENV_FILE"
  exit 1
fi
source "$ENV_FILE"

if [ -z "${POSTGRES_VOLUME_NAME:-}" ]; then
  echo "\$POSTGRES_VOLUME_NAME ENV_VAR was not set when read by reset_db_volume.sh"
  exit 1
fi

echo "This will permanently delete the Docker volume '$POSTGRES_VOLUME_NAME'."
echo "All database data stored in that volume will be permanently lost."
read -p "Continue? [y/N]: " CONFIRMATION

if [ "$CONFIRMATION" = "y" ] || [ "$CONFIRMATION" = "Y" ]; then
  echo "Deleting Docker volume $POSTGRES_VOLUME_NAME"
  docker volume rm "$POSTGRES_VOLUME_NAME"
else
  echo "Aborted, no volume was deleted."
fi
