CREATE TABLE IF NOT EXISTS myportfolio.projects (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    summary TEXT NOT NULL,
    employment_type VARCHAR(50),
    location_type VARCHAR(50),
    description TEXT,
    visible BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS myportfolio.skills (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    version VARCHAR(32),
    category VARCHAR(32),
    active BOOLEAN DEFAULT true,
    CONSTRAINT unique_skill UNIQUE (name, version)
);

CREATE TABLE IF NOT EXISTS myportfolio.projects_skills (
    project_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    skill_priority BIGINT,
    usage_percentage NUMERIC(5, 2) CHECK (usage_percentage >= 0 AND usage_percentage <= 100),
    PRIMARY KEY (project_id, skill_id)
);

CREATE TABLE IF NOT EXISTS myportfolio.companies (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    industry VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    logo_url VARCHAR NOT NULL,
    city VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    address TEXT,
    phone VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_company UNIQUE (name, industry, department)
);

ALTER TABLE myportfolio.projects
    ADD CONSTRAINT fk_project_company
    FOREIGN KEY (company_id) REFERENCES myportfolio.companies (id)
    ON DELETE SET NULL;
