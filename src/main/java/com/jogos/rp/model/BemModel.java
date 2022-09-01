package com.jogos.rp.model;

import com.jogos.rp.model.bemModels.AlimentoModel;
import com.jogos.rp.model.bemModels.ArmaModel;
import com.jogos.rp.model.bemModels.CarroBemModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BemModel {

    private List<CarroBemModel> carros;
    private List<CasaBemModel> casas;

}