/* Table for plots */
CREATE TABLE plots (
    id                    integer        PRIMARY KEY,
    name                  text           CONSTRAINT users_auth_unique UNIQUE,
    owner                 text           NOT NULL,
    width                 integer        NOT NULL,
    length                integer        NOT NULL,
    slot            	  text           CONSTRAINT plots_slot_valid CHECK (slot in ('Morning', 'Noon', 'Evening', 'Night')),,
    irrigationStatus      boolean        NOT NULL DEFAULT false,  
    created_at            timestamptz    NOT NULL DEFAULT current_timestamp
);
