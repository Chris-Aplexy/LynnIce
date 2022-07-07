package com.lynicecreamapp.lyn_user_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offer {

    private long offerId;
    private String OfferName;
    private String offerDescription;
    private String owner;
}
