<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220428092452 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE clients (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR(255) NOT NULL, age INTEGER NOT NULL, solicitor VARCHAR(255) NOT NULL)');
        $this->addSql('CREATE TABLE secret_mode (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, daredevil BOOLEAN NOT NULL, successful_nights INTEGER NOT NULL)');
        $this->addSql('ALTER TABLE solicitors ADD COLUMN name VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE clients');
        $this->addSql('DROP TABLE secret_mode');
        $this->addSql('CREATE TEMPORARY TABLE __temp__solicitors AS SELECT id, courts, clients FROM solicitors');
        $this->addSql('DROP TABLE solicitors');
        $this->addSql('CREATE TABLE solicitors (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, courts VARCHAR(255) NOT NULL, clients VARCHAR(255) NOT NULL)');
        $this->addSql('INSERT INTO solicitors (id, courts, clients) SELECT id, courts, clients FROM __temp__solicitors');
        $this->addSql('DROP TABLE __temp__solicitors');
    }
}
